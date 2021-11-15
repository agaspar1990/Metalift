package com.nice.service;


import com.nice.dto.UserDto;
import com.nice.entity.Role;
import com.nice.entity.User;

import com.nice.mapstruct.MapstructMapper;
import com.nice.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapstructMapper mapstructMapper;
    private final PasswordEncoder passwordEncoder;



    @Transactional
    public UserDto create(UserDto request) {


        if (userRepository.findByUserName(request.getUsername()).getUsername().length() > 0) {

            throw new ValidationException("Username exists!");
        }
        if (!request.getPassword().equals(request.getRePassword())) {
            throw new ValidationException("Passwords don't match!");
        }
        if (request.getAuthorities() == null) {
            request.setAuthorities(new HashSet<>());
        }



        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = userRepository.saveAndFlush(mapstructMapper.userDtoToUser(request));

        return mapstructMapper.userToUserDto(user);
    }

    @Transactional
    public UserDto update(UUID id, UserDto request) {
       UserDto userFromDb = mapstructMapper.userToUserDto(userRepository.findByUserName(request.getUsername()));

        userFromDb.setUsername(request.getUsername());
        userFromDb.setPassword(request.getPassword());
        userFromDb.setId(request.getId());
        userFromDb.setFullName(request.getFullName());
        userFromDb.setRePassword(request.getRePassword());
        userFromDb.setAuthorities(request.getAuthorities());


        userRepository.save(mapstructMapper.userDtoToUser(userFromDb));

        return request;
    }

    @Override
    public UserDto upsert(UserDto request) {
        User optionalUser = userRepository.findByUserName(request.getUsername());

        if (optionalUser.getUsername().length() <= 0) {
            return create(request);
        } else {
            UserDto updateUserRequest = new UserDto();
            updateUserRequest.setFullName(request.getFullName());
            return update(optionalUser.getId(), updateUserRequest);
        }
    }


    @Transactional
    public UserDto delete(UUID id) {
        User user = userRepository.getById(id);

        user.setUsername(user.getUsername().replace("@", String.format("_%s@", user.getId())));
        user.setEnabled(false);
        user = userRepository.save(user);

        return mapstructMapper.userToUserDto(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username);

    }

    public boolean usernameExists(String username) {
        if (userRepository.findByUserName(username).getUsername().length() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public UserDto getUser(UUID id) {
        return mapstructMapper.userToUserDto(userRepository.getById(id));
    }

    @Override
    public List<UserDto> searchUsers(Page page, UserDto query) {
        List<User> users = userRepository.searchUsers(page, query);
        return (List<UserDto>) users.stream().map(u -> mapstructMapper.userToUserDto(u));

    }



}

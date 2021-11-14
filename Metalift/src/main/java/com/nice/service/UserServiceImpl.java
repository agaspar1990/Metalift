package com.nice.service;

import com.nice.dto.UserDto;
import com.nice.entity.User;
import com.nice.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import mapper.UserEditMapper;
import mapper.UserViewMapper;
import org.springframework.data.domain.Page;
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

import com.nice.repository.UserRepository;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEditMapper userEditMapper;
    private final UserViewMapper userViewMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto create(UserDto request) {


        if (userRepository.findByUserName(request.getUsername()).isPresent()) {
            throw new ValidationException("Username exists!");
        }
        if (!request.getPassword().equals(request.getRePassword())) {
            throw new ValidationException("Passwords don't match!");
        }
        if (request.getAuthorities() == null) {
            request.setAuthorities(new HashSet<>());
        }

        User user = userEditMapper.create(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user = userRepository.save(user);

        return userViewMapper.toUserView(user);
    }

    @Transactional
    public UserDto update(UUID id, UserDto request) {
        User user = userRepository.getById(id);
        userEditMapper.update(request, user);

        user = userRepository.save(user);

        return userViewMapper.toUserView(user);
    }

    @Transactional
    public UserDto upsert(UserDto request) {
        Optional<User> optionalUser = userRepository.findByUserName(request.getUsername());

        if (optionalUser.isEmpty()) {
            return create(request);
        } else {
            UserDto updateUserRequest = new UserDto();
            updateUserRequest.setFullName(request.getFullName());
            return update(optionalUser.get().getId(), updateUserRequest);
        }
    }

    @Transactional
    public UserDto delete(UUID id) {
        User user = userRepository.getById(id);

        user.setUsername(user.getUsername().replace("@", String.format("_%s@", user.getId())));
        user.setEnabled(false);
        user = userRepository.save(user);

        return userViewMapper.toUserView(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUserName(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(format("User with username - %s, not found", username))
                );
    }

    public boolean usernameExists(String username) {
        return userRepository.findByUserName(username).isPresent();
    }

    public UserDto getUser(UUID id) {
        return userViewMapper.toUserView(userRepository.getById(id));
    }

    public List<UserDto> searchUsers(Page page, UserDto query) {
        List<User> users = userRepository.searchUsers(page, query);
        return userViewMapper.toUserView(users);
    }

}

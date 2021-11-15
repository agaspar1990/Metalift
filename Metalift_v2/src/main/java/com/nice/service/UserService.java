package com.nice.service;

import com.nice.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserDto create(UserDto request);
    UserDto update(UUID id, UserDto request);
    UserDto upsert(UserDto request);
    UserDto delete(UUID id);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    boolean usernameExists(String username);
    UserDto getUser(UUID id);
    List<UserDto> searchUsers(Page page, UserDto query);

}
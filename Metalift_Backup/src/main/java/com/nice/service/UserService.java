package com.nice.service;
import com.nice.entity.Exercise;
import com.nice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public interface UserService {
    Page<Exercise> getUsers(Pageable pageable);

    Exercise getUserById(UUID id);

    Exercise createUser(User user);

    Exercise updateUser(UUID id, User user);

    void deleteUser(UUID id);

}

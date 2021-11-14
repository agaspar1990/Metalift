package com.nice.repository;

import com.nice.dto.UserDto;
import com.nice.entity.Exercise;
import com.nice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Cacheable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    public Optional<User> findByUserName(String userName);

    public List<User> searchUsers(Page page, UserDto query);


}
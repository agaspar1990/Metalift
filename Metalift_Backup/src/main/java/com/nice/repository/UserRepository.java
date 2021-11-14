package com.nice.repository;

import com.nice.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Exercise, UUID> {
}
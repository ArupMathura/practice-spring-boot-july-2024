package com.example.practiceSpringBoot.repository;

import com.example.practiceSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

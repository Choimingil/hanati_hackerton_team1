package com.hanati.team1.src.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanati.team1.src.customers.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

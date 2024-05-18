package com.hanati.team1.src.customers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hanati.team1.src.customers.entities.User;
import com.hanati.team1.src.customers.models.GetMyInfoRes;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("")
	Optional<GetMyInfoRes> findMyInfo(long userId);
}

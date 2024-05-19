package com.hanati.team1.src.customers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanati.team1.src.customers.entities.Subscribe;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {
	Optional<Subscribe> findByPlayerIdAndUserId(long playerId, long userId);
}

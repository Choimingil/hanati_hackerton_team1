package com.hanati.team1.src.customers.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanati.team1.src.customers.models.GetMyInfoRes;
import com.hanati.team1.src.customers.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

	private final UserRepository userRepository;

	public GetMyInfoRes getMyInfo() {
		long userId = 1L;
		return userRepository.findMyInfo(userId)
			.orElseThrow(() -> new IllegalArgumentException("잘못된 요청입니다."));
	}
}

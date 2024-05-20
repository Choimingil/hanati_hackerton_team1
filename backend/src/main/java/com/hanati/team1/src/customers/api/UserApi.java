package com.hanati.team1.src.customers.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanati.team1.src.customers.models.GetMyInfoRes;
import com.hanati.team1.src.customers.models.GetTokenRes;
import com.hanati.team1.src.customers.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserApi {

	private final UserService userService;

	@GetMapping
	public GetMyInfoRes getMyInfo() {
		return userService.getMyInfo();
	}

	@GetMapping("/tokens")
	public Map<String, List<GetTokenRes>> getMyTokenList() {
		List<GetTokenRes> myTokenList = userService.getMyTokenList();
		return Map.of("data", myTokenList);
	}
}

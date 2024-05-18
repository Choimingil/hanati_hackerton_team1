package com.hanati.team1.src.players.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanati.team1.src.players.models.GetProspectRes;
import com.hanati.team1.src.players.service.ProspectService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/prospects")
@RestController
public class ProspectApi {

	private final ProspectService prospectService;

	@GetMapping
	public Map<String, List<GetProspectRes>> getProspectList(@RequestParam("keyword") String keyword) {
		List<GetProspectRes> resList = prospectService.getProspectList(keyword);
		return Map.of("data", resList);
	}
}

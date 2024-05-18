package com.hanati.team1.src.players.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hanati.team1.src.players.models.GetProspectDetailRes;
import com.hanati.team1.src.players.models.GetProspectRes;
import com.hanati.team1.src.players.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProspectService {

	private final PlayerRepository playerRepository;

	public List<GetProspectRes> getProspectList(String keyword) {
		if (!StringUtils.hasText(keyword)) {
			keyword = "";
		}
		return playerRepository.findAllProspects(keyword);
	}

	public GetProspectDetailRes getProspectDetail(long prospectId) {
		return playerRepository.findProspectById(prospectId)
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유망주입니다."));
	}
}

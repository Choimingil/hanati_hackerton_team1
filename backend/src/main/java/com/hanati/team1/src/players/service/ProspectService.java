package com.hanati.team1.src.players.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hanati.team1.src.players.entities.Player;
import com.hanati.team1.src.players.models.GetProspectDetailRes;
import com.hanati.team1.src.players.models.GetProspectRes;
import com.hanati.team1.src.players.models.PostProspectReq;
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
		long userId = 1L;
		return playerRepository.findProspectById(prospectId, userId)
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유망주입니다."));
	}

	public void saveProspect(PostProspectReq postProspectReq) {
		// TODO: profile, video 쪽 S3에 미리 넣어둔 파일저장경로 url 고정으로 박아두기
		Player player = postProspectReq.toEntity("temp", "temp");
		playerRepository.save(player);
	}
}

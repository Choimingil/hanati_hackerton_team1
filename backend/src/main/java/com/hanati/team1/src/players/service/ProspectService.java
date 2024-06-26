package com.hanati.team1.src.players.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hanati.team1.src.customers.entities.Subscribe;
import com.hanati.team1.src.customers.repository.SubscribeRepository;
import com.hanati.team1.src.players.entities.Player;
import com.hanati.team1.src.players.models.GetProspectDetailRes;
import com.hanati.team1.src.players.models.GetProspectRes;
import com.hanati.team1.src.players.models.PostProspectReq;
import com.hanati.team1.src.players.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProspectService {

	private final PlayerRepository playerRepository;
	private final SubscribeRepository subscribeRepository;

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

	@Transactional
	public void saveProspect(PostProspectReq postProspectReq) {
		Player player = postProspectReq.toEntity();
		playerRepository.save(player);
	}

	@Transactional
	public void saveSubscribe(long prospectId) {
		long userId = 1L;

		Optional<Subscribe> optionalSubscribe = subscribeRepository.findByPlayerIdAndUserId(prospectId, userId);
		if (optionalSubscribe.isPresent()) {
			Subscribe subscribe = optionalSubscribe.get();
			subscribe.saveSubscribe();
			return;
		}

		Subscribe subscribe = Subscribe.builder()
			.userId(userId)
			.playerId(prospectId)
			.build();
		subscribeRepository.save(subscribe);
	}

	@Transactional
	public void deleteSubscribe(long prospectId) {
		long userId = 1L;
		Subscribe subscribe = subscribeRepository.findByPlayerIdAndUserId(prospectId, userId)
			.orElseThrow(() -> new IllegalArgumentException("잘못된 요청입니다."));
		subscribe.cancelSubscribe();
	}
}

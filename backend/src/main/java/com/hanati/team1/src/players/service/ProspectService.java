package com.hanati.team1.src.players.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hanati.team1.src.players.models.GetProspectRes;
import com.hanati.team1.src.players.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProspectService {

	private final PlayerRepository playerRepository;

	public List<GetProspectRes> getProspectList() {
		return playerRepository.findAllProspects();
	}
}

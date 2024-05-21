package com.hanati.team1.src.players.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanati.team1.src.players.models.GetProspectDetailRes;
import com.hanati.team1.src.players.models.GetProspectRes;
import com.hanati.team1.src.players.models.PostProspectReq;
import com.hanati.team1.src.players.service.ProspectService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/prospects")
@RestController
public class ProspectApi {

	private final ProspectService prospectService;

	@GetMapping
	public Map<String, List<GetProspectRes>> getProspectList(
		@RequestParam(value = "keyword", required = false) String keyword) {
		List<GetProspectRes> resList = prospectService.getProspectList(keyword);
		return Map.of("data", resList);
	}

	@GetMapping("/{prospect_id}")
	public GetProspectDetailRes getProspectDetail(@PathVariable("prospect_id") long prospectId) {
		return prospectService.getProspectDetail(prospectId);
	}

	@PostMapping
	public void saveProspect(@RequestBody PostProspectReq postProspectReq) {
		prospectService.saveProspect(postProspectReq);
	}

	@PostMapping("/{prospect_id}/subscribe")
	public void saveSubscribe(@PathVariable("prospect_id") long prospectId) {
		prospectService.saveSubscribe(prospectId);
	}

	@DeleteMapping("/{prospect_id}/subscribe")
	public void deleteSubscribe(@PathVariable("prospect_id") long prospectId) {
		prospectService.deleteSubscribe(prospectId);
	}
}

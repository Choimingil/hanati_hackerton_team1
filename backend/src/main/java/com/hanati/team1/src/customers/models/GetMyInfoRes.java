package com.hanati.team1.src.customers.models;

import java.util.List;

public record GetMyInfoRes(
	String name,
	String profile,
	int totalAsset,
	int totalCntToken,
	List<GetTokenRes> myAssetList
) {
}

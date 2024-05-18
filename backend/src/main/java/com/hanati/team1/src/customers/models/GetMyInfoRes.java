package com.hanati.team1.src.customers.models;

public record GetMyInfoRes(
	String name,
	String profile,
	int totalAsset,
	int totalCntToken
) {
}

package com.company.tetris.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
	private String roomId;
	private String hostUserId;
	private int maxCapacity; //최대정원 흠...네명까지? 할수?있을까? 그냥 두명까지만 할까
	private List<String> participants = new ArrayList<>(); //참여 유저 정보 조회
	private Map<String, Boolean> readyStatus = new HashMap<>(); //준비상태 조회
	
	//현재 인원이 정원 이상인가?
	public boolean isFull() { return participants.size() >= maxCapacity; }
	
	//유저가 모두 준비 상태인가?
	public boolean allReady() {return readyStatus.values().stream().allMatch();}
	
	//해당 유저가 방장인가?
	public boolean isHost(String userId) {}
}

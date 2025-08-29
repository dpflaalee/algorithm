package com.company.tetris.websocket;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.company.tetris.dto.GameState;

//각 유저 게임 상태 반환하는... 일대 다 통신용 유틸
@Component
public class GameEventBroadcaster {
	@Autowired private SimpMessagingTemplate messagingTemplate;
	
	public void broadcastCameState(String roomId, Map<String, GameState> states) {
		messagingTemplate.convertAndSend("/topic/game/"+roomId, states);
	}
}

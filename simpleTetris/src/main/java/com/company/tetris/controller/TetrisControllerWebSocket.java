package com.company.tetris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.company.tetris.dto.GameMove;
import com.company.tetris.service.GameSession;
import com.company.tetris.service.GameSessionManager;
import com.company.tetris.service.PlayerGameService;
import com.company.tetris.websocket.GameEventBroadcaster;

@Controller
public class TetrisControllerWebSocket {
	private final GameSessionManager sessionManager;
	private final GameEventBroadcaster broadcaster;
	
	@Autowired
	public TetrisControllerWebSocket(GameSessionManager sessionManager, GameEventBroadcaster broadcaster) {
		this.sessionManager = sessionManager;
		this.broadcaster = broadcaster;
	}
	
	@MessageMapping("/move")
	public void handleMove(GameMove move) {
		GameSession session = sessionManager.getSession(move.getRoomId());
		PlayerGameService player = session.getPlayer(move.getUserId());
		player.move(move.getDirection());
		
		broadcaster.broadcastCameState(move.getRoomId(), session.getAllStates());
	}
	
	@MessageMapping("/drop")
	public void handleDrop(GameMove move) {
		GameSession session = sessionManager.getSession(move.getRoomId());
		PlayerGameService player = session.getPlayer(move.getUserId());
		player.drop();
		
		broadcaster.broadcastCameState(move.getRoomId(), session.getAllStates());
	}
}

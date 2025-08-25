package com.company.tetris.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.company.tetris.service.GameService;

@Controller
public class GameControllerWebSocket {
	private final GameService gameService;
	private final GameWebSocket gameWebSocket;
	
	@Autowired
	public GameControllerWebSocket(GameService gameService, GameWebSocket gameWebSocket) {
		this.gameService = gameService;
		this.gameWebSocket = gameWebSocket;
	}
}

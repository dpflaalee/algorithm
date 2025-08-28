package com.company.tetris.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.company.tetris.service.TetrisService;

@Controller
public class TetrisControllerWebSocket {
	private final TetrisService tetrisService;
	private final TetrisWebSocket tetrisWebSocket;
	
	@Autowired
	public TetrisControllerWebSocket(TetrisService tetrisService,  TetrisWebSocket tetrisWebSocket) {
		this.tetrisService = tetrisService;
		this.tetrisWebSocket = tetrisWebSocket;
	}
	
	@MessageMapping("/move")
	public void handleMove(String direction) {
		tetrisService.move(direction);
		tetrisWebSocket.sendGameState();
	}
	
	@MessageMapping("/drop")
	public void handleDrop() {
		tetrisService.drop();
		tetrisWebSocket.sendGameState();
	}
	
    @MessageMapping("/pause")
    public void handlePause() {
        tetrisService.pause();
        tetrisWebSocket.sendGameState();
    }

    @MessageMapping("/resume")
    public void handleResume() {
        tetrisService.resume();
        tetrisWebSocket.sendGameState();
    }

    @MessageMapping("/restart")
    public void handleRestart() {
        tetrisService.restart();
        tetrisWebSocket.sendGameState();
        tetrisWebSocket.sendRestartMessage();
    }
}

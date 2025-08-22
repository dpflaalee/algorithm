package com.company.tetris.websocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.company.tetris.service.GameService;

@Component
public class GameWebSocket {
	//클라이언트에 게임 보드의 상태와 현재 블록의 상태 전송하기 위한 설정
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	private GameService gameService;
	
	@Autowired public void setGameService(@Lazy GameService gameService) {this.gameService = gameService;}
	public void sendBoardState() {
		//List<String> nextBlockTypes = gameService.getNextBlockTypes();
	}
}

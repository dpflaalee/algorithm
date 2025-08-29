package com.company.tetris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.company.tetris.dto.RoomRequest;
import com.company.tetris.model.User;
import com.company.tetris.service.RoomService;

@Controller
public class RoomWebSocketController {
	private final RoomService roomService;
	private final SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	public RoomWebSocketController(RoomService roomService, SimpMessagingTemplate messagingTemplate) {
		this.roomService = roomService;
		this.messagingTemplate = messagingTemplate;
	}
	
	@MessageMapping("/room/create")
    public void createRoom(RoomRequest request) {
        String roomId = roomService.createRoom(request.getHostId(), request.getMaxPlayers());
        messagingTemplate.convertAndSend("/topic/rooms", roomService.getRoomList());
    }

    @MessageMapping("/room/join")
    public void joinRoom(RoomRequest request) {
        roomService.joinRoom(request.getRoomId(), new User(request.getUserId()));
        messagingTemplate.convertAndSend("/topic/room/" + request.getRoomId(), roomService.getRoom(request.getRoomId()));
    }

    @MessageMapping("/room/ready")
    public void toggleReady(RoomRequest request) {
        roomService.toggleReady(request.getRoomId(), request.getUserId());
        messagingTemplate.convertAndSend("/topic/room/" + request.getRoomId(), roomService.getRoom(request.getRoomId()));
    }

    @MessageMapping("/room/start")
    public void startGame(RoomRequest request) {
        if (roomService.canStartGame(request.getRoomId(), request.getUserId())) {
            messagingTemplate.convertAndSend("/topic/room/" + request.getRoomId() + "/start", "Game Started");
        }
    }

    @MessageMapping("/room/leave")
    public void leaveRoom(RoomRequest request) {
        roomService.leaveRoom(request.getRoomId(), request.getUserId());
        messagingTemplate.convertAndSend("/topic/room/" + request.getRoomId(), roomService.getRoom(request.getRoomId()));
    }

    @MessageMapping("/room/delete")
    public void deleteRoom(RoomRequest request) {
        roomService.removeRoom(request.getRoomId());
        messagingTemplate.convertAndSend("/topic/rooms", roomService.getRoomList());
    }
}

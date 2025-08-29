package com.company.tetris.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.company.tetris.model.Room;
import com.company.tetris.model.User;

@Service
public class RoomService {
	private final Map<String, Room> roomMap = new ConcurrentHashMap<>();
	private final Map<String, String> userRoomMap = new ConcurrentHashMap<>();
	
	//방 만들기
	public String createRoom(String hostId, int maxPlayers) {
		Room room = new Room(hostId, maxPlayers);
		roomMap.put(room.getRoomId(), room);
		return room.getRoomId();
	}
	
	//방 조회
	public List<Room> getRoomList(){ return new ArrayList<>(roomMap.values()); }
	
	//단일 방 조회
	public Room getRoom(String roomId) { return roomMap.get(roomId);}
	
	//방 참여
	public boolean joinRoom(String roomId, User user) {
		//한 유저가 여러 방 입장하는 걸 방지
		String currentRoomId = userRoomMap.get(user.getUserId());
		if(currentRoomId != null && !currentRoomId.equals(roomId)) {leaveRoom(currentRoomId, user.getUserId());}
		
		Room room = roomMap.get(roomId);
		if(room==null || room.isFull()) return false;
		
		boolean joined = room.addUser(user);
		if(joined) userRoomMap.put(user.getUserId(), roomId);
		
		return room.addUser(user);
	}
	
	//준비 상태
	public boolean toggleReady(String roomId, String userId) {
		Room room = roomMap.get(roomId);
		if(room==null) return false;
		User user = room.getParticipants().stream()
				.filter(u->u.getUserId().equals(userId))
				.findFirst().orElse(null);
		if(user==null) return false;
		user.setReady(!user.isReady());
		return true;
	}
	
	//전체 준비상태 확인
	public boolean canStartGame(String roomId, String userId) {
		Room room = roomMap.get(roomId);
		if(room == null) return false;
		return room.isHost(userId)&&room.isReady();
	}
	
	//방 삭제
	public void removeRoom(String roomId) {roomMap.remove(roomId);}
	
	//나가기
	public void leaveRoom(String roomId, String userId) {
		Room room = roomMap.get(roomId);
		if(room != null) {
			room.removeUser(userId);
			if(room.getParticipants().isEmpty()){
				removeRoom(roomId);
			}
		}
	}
	
	
}

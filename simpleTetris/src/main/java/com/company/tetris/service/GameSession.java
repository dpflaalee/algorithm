package com.company.tetris.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.company.tetris.dto.GameState;

//플레이어별 게임 상태 관리
public class GameSession {
    private final Map<String, PlayerGameService> players = new ConcurrentHashMap<>();

    public PlayerGameService getPlayer(String userId) {
        return players.computeIfAbsent(userId, id -> new PlayerGameService());
    }

    public Map<String, GameState> getAllStates() {
        return players.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getCurrentState()));
    }

    public void removePlayer(String userId) { players.remove(userId); }
}

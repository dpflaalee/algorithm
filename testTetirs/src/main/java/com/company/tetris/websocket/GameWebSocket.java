package com.company.tetris.websocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.company.tetris.block.Block;
import com.company.tetris.model.BlockState;
import com.company.tetris.model.BoardState;
import com.company.tetris.model.GhostBlockState;
import com.company.tetris.model.HoldBlockState;
import com.company.tetris.service.GameService;

@Component
public class GameWebSocket {
	//클라이언트에 게임 보드의 상태와 현재 블록의 상태 전송하기 위한 설정
	
	@Autowired
    private SimpMessagingTemplate messagingTemplate;

    private GameService gameService;

    @Autowired
    public void setGameService(@Lazy GameService gameService) {
        this.gameService = gameService;
    }

    public void sendBoardState() {
        List<String> nextBlockTypes = gameService.getNextBlockTypes();

        BoardState boardState = BoardState.builder()
                .gameBoard(gameService.getBoard().getGameBoard())
                .totalClearLine(gameService.getTotalClearLines())
                .level(gameService.getLevel())
                .nextBlock(nextBlockTypes)
                .build();

        messagingTemplate.convertAndSend("/topic/boardState", boardState);
    }

    public void sendControlBlockState() {
        Block controlBlock = gameService.getControlBlock();
        if (controlBlock != null) {
            BlockState blockState = new BlockState(
                    controlBlock.getX(),
                    controlBlock.getY(),
                    controlBlock.getType(),
                    controlBlock.getShape(),
                    controlBlock.getCurrentRotation(),
                    controlBlock.getShapes()
            );
            messagingTemplate.convertAndSend("/topic/controlBlockState", blockState);
        }
    }

    public void sendHoldBlockState(String holdBlockType) {
        HoldBlockState holdBlockState = new HoldBlockState(gameService.getHoldBlockType());
        messagingTemplate.convertAndSend("/topic/holdBlockState", holdBlockState);
    }

    public void sendGhostBlockState(GhostBlockState ghostBlockState) {
        if (ghostBlockState != null) {
            messagingTemplate.convertAndSend("/topic/ghostBlock", ghostBlockState);
        }
    }
    public void sendRestartGame() {
        messagingTemplate.convertAndSend("/topic/restartGame", "Game has restarted");
    }
}

package com.company.tetris.service;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.tetris.block.*;
import com.company.tetris.board.Board;
import com.company.tetris.model.GhostBlockState;
import com.company.tetris.websocket.GameWebSocket;

import lombok.Getter;

@Service @Getter
public class GameService {

	private Board board; // 게임이 이루어지는 보드
	private BlockPool blockPool;
	private Block controlBlock; //사용자조작 블록
	private final LinkedList<Block> bag = new LinkedList<>();
	private MoveBlock moveBlock;
	private GhostBlockState ghostBlockState;
	private ScheduledExecutorService executorService;
	private volatile boolean gameStateUpdate = false;
	private int totalClearLine = 0; //클리어한 총 라인 수
	private int level = 1; //게임 레벨 20라인 클리어하면 1씩 증가
	private long dropInterval = 1000; // 블록 떨어지는 속도 > 1초에 1칸 레벨 증가 시 1/10씩 감소
	private final Queue<Block> nextBlocks = new LinkedList<>();
	private String holdBlockType = null;
	private boolean canHold = true;
	@Getter private boolean isPaused = false; //정지
	
	@Autowired private GameWebSocket gameWebSooket;
	
	@PostConstruct // 객체 생성 후 자동으로 초기화
	public void init() {
		this.blockPool = new BlockPool();
		this.board = new Board();
        this.moveBlock = new MoveBlock(board);
        //fillBag();  // 7-bag규칙에 따른 블럭배열 생성
        //createNextBlocks();    //미리보기 블록 준비
	}
	
}

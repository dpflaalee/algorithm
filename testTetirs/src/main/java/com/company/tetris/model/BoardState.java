package com.company.tetris.model;

import java.util.List;

import com.company.tetris.board.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Builder @Data @NoArgsConstructor
public class BoardState {
	private boolean[][] gameBoard = new boolean[Board.GAME_BOARD_HEIGHT][Board.GAME_BOARD_WIDTH];
	private int totalClearLine;
	private int level;
	private List<String> nextBlock;

}

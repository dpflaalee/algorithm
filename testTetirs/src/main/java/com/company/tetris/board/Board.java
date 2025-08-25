package com.company.tetris.board;

import java.util.Arrays;

import com.company.tetris.block.Block;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Board {
	
	public static final int GAME_BOARD_WIDTH=10; //게임판 가로 행 10
	public static final int GAME_BOARD_HEIGHT=22; //게임판 세로 열 22
	public boolean [][] gameBoard = new boolean[GAME_BOARD_HEIGHT][GAME_BOARD_WIDTH];
	
	public Board() { newGameBoard(); }
	public void newGameBoard() {  // 초기화된 게임판 생성
		for(int i=0; i<GAME_BOARD_HEIGHT; i++) {Arrays.fill(gameBoard[i], false);}
	}
	
	public void stackedBlock(Block block) { // 블록이 쌓인 위치 값 변경
		for(int[]part:block.getShape()) { //part : 블록의 (y, x) 배열 block.getShape()현재 블록 모양을 나타내는 배열
			int x = block.getX() + part[0];
			int y = block.getY() + part[1];
			if( x<0 || x >= GAME_BOARD_WIDTH || y<0 || y >= GAME_BOARD_HEIGHT ) {continue;}
			gameBoard[y][x] = true;
		}
	}
	
	public boolean gameOverLineCheck(int row) {   //GameBoard해당 라인에 블럭이 하나라도 쌓이면 true
        for (int col = 0; col < GAME_BOARD_WIDTH; col++) {
            if (gameBoard[row][col]) {
                return true; // 해당 줄에 블록이 하나라도 있으면 true 반환
            }
        }
        return false; // 줄에 블록이 없으면 false 반환
    }
	
	public int lineClear() {
		int clearLineCount = 0;
		for(int row = GAME_BOARD_HEIGHT-1; row>=0; row--) {
			boolean isLineFull = true;
			for(boolean cell : gameBoard[row]) {
				if(!cell) {isLineFull=false; break;}
			}
			if(isLineFull) {
				clearLineCount++;
				for(int moveRow=row; moveRow>0; moveRow--) { // 현재 삭제된 줄을 최상단으로 이동
					gameBoard[moveRow]=gameBoard[moveRow-1];
				}
				gameBoard[0] = new boolean[GAME_BOARD_WIDTH]; // 최상단에 새 줄 생성
				row++; // 중복 검사 피하기 위해 row 한칸 내리기
			}
		} 
		return clearLineCount;
	}
}

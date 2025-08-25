package com.company.tetris.logic;

import java.util.List;

//DTO
public class GameState {
	private int[][] board;
	private Point[] current;
	private int score;
	
	public GameState(int[][]board,Point[] current, int score) {
		this.board = board;
		this.current = current;
		this.score = score;
	}
	
	public int[][] getBoard(){ return board; }
	public Point[] getCurrent(){return current;}
	public int getScore() {return score;}
}

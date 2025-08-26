package com.company.tetris.logic;

//DTO
public class GameState {
	private int[][] board;
	private Point[] current;
	private int score;
	private boolean gameOver;
	private boolean isPaused;
	
	public GameState(int[][] board, Point[] current, int score, boolean gameOver, boolean isPaused) {
		this.board = board;
		this.current = current;
		this.score = score;
		this.gameOver = gameOver;
		this.isPaused = isPaused;
	}
	
	public boolean isGameOver() { return gameOver;}
	public boolean isPaused() {return isPaused;}
	public int[][] getBoard(){ return board; }
	public Point[] getCurrent(){return current;}
	public int getScore() {return score;}
}

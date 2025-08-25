package com.company.tetris.service;

import org.springframework.stereotype.Service;

import com.company.tetris.logic.GameState;
import com.company.tetris.logic.Point;
import com.company.tetris.logic.ScoreManager;
import com.company.tetris.logic.TetrisBoard;
import com.company.tetris.logic.Tetromino;
import com.company.tetris.logic.TetrominoGenerator;

@Service
public class TetrisService {
	private TetrisBoard board = new TetrisBoard();
	private TetrominoGenerator generator = new TetrominoGenerator();
	private ScoreManager scoreManager = new ScoreManager();
	
	public void spawn() {
		Tetromino t = generator.next();
		t.setPosition(new Point(4, 0));
		board.spawn(t);
	}
	
	public void move(String direction) {
		Tetromino t = board.getCurrent();
		switch (direction) {
			case "left": t.move(-1, 0); break;
			case "right": t.move(1, 0); break;
			case "down": t.move(0, 1); break;
			case "rotate": t.rotateClockwise(); break;
		}
	}
	
	public void drop() {
		Tetromino t = board.getCurrent();
		while (board.canMove(t)) {
			t.move(0, 1);
		}
		t.move(0, -1);
		board.fixTetromino();
		int lines = board.claerLines();
		scoreManager.addScore(lines);
	}
	
	public GameState getCurrentState() {
		Tetromino current = board.getCurrent();
		Point[]blocks = current != null ? current.getAbsoluteBlocks() : new Point[0];
		return new GameState(board.getBoard(), blocks, scoreManager.getScore());
	}
	
	public int getScore() {return scoreManager.getScore();}
}

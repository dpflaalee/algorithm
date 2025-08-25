package com.company.tetris.logic;

import java.util.Random;

//랜덤 생성
public class TetrominoGenerator {
	private static final char[] TYPES = {'I', 'O', 'T', 'S', 'Z', 'J', 'L'};
	private Random rand = new Random();
	
	public Tetromino next() {
		char type = TYPES[rand.nextInt(TYPES.length)];
		return new Tetromino(type);
	}
}

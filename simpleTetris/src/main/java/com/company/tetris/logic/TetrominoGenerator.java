package com.company.tetris.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//랜덤 생성
public class TetrominoGenerator {
//	private static final char[] TYPES = {'I', 'O', 'T', 'S', 'Z', 'J', 'L'};
//	private Random random = new Random();
//	
//	public Tetromino next() {
//		char type = TYPES[random.nextInt(TYPES.length)];
//		return new Tetromino(type);
//	}
	
	private List<Character> bag = new ArrayList<>();
	private Random random = new Random();
	
	public Tetromino next() {
		if(bag.isEmpty()) refillBag();
		char type = bag.remove(0);
		return new Tetromino(type);
	}
	
	private void refillBag() {
//		bag = Arrays.asList('I', 'O', 'T', 'S', 'Z', 'J', 'L');
//		Collections.shuffle(bag, random);
	    List<Character> types = Arrays.asList('I', 'O', 'T', 'S', 'Z', 'J', 'L');
	    bag = new ArrayList<>(types); 
	    Collections.shuffle(bag, random);
	}
}

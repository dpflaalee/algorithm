package com.company.tetris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class GhostBlockState {
	private int x;
	private int y;
	private int [][] shape;
	private int currentRotation;
}

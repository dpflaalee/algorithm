package com.company.tetris.block;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Block {
	protected int[][][] shapes; //회전 상태 저장
	protected int currentRotation=0; //0: 초기블록 , 1: 90도 회전 , 2: 180도 회전 , 4: 270도 회전 
	protected int [][] shape; //블록의 현재 모양
	protected int x, y; // 블록 위치
	protected String type; // 블록 타입
	
	public Block(int[][][] shapes) {
		this.shapes = shapes;
		this.shape = shapes[currentRotation];
		this.x=0;
		this.y=0;
	}
	
	// 1. 블록 회전 - 시계방향
	public void rotation() { 
		currentRotation = (currentRotation+1) % shapes.length; //다른 회전 상태
		this.shape = shapes[currentRotation]; //모양 업데이트
	}
	// 2. 블록 회전 - 반시계방향
	public void reversRotation() {
		currentRotation = (currentRotation-1 + shapes.length) % shapes.length; // 다음 회전 상태
		this.shape = shapes[currentRotation]; // 모양 업데이트
	}
	
	public void reset() {
		currentRotation=0;
		shape=shapes[currentRotation];
		x=0; y=0;
	}
	
	

}

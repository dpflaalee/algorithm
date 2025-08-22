package com.company.tetris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BlockState {
	private int x;
	private int y;
	private String type; // 블록 타입
	private int[][]shape; // 타입별 회전에 따른 모양 저장
	private int currentRotation; // 현재 블록 회전상태 저장
	private int [][][] shapes; // 회전 상태까지 같이 저장
}

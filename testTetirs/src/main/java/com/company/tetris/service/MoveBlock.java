package com.company.tetris.service;

import com.company.tetris.block.Block;
import com.company.tetris.board.Board;

public class MoveBlock {
	
	private final Board board;
	
	//시계방향 회전
	private final int[][][]rotationWallKickDateJLSTZ = {
            { {0, 0}, {-1, 0}, {-1, 1}, {0, -2}, {-1, -2} },//0->1
            { {0, 0}, {1, 0}, {1, -1}, {0, 2}, {1, 2} },      //1->2
            { {0, 0}, {1, 0}, {1, 1}, {0, -2}, {1, -2} },   //2->3
            { {0, 0}, {-1, 0}, {-1, -1}, {0, 2}, {-1, 2} } //3->0
	};
	//반시계방향 회전
	private final int[][][] reversRotationWallKickDateJLSTZ = {
            { {0, 0}, {1, 0}, {1, 1}, {0, -2}, {1, -2} },//0->3
            { {0, 0}, {1, 0}, {1, -1}, {0, 2}, {1, 2} },     //1->0
            { {0, 0}, {-1, 0}, {-1, 1}, {0, -2}, {-1, -2} },     //2->1
            { {0, 0}, {-1, 0}, {-1, -1}, {0, 2}, {-1, 2} }    //3->2
	};
	//I블록 시계방향 회전
	private final int[][][] rotationWallKickDataI = {
	        { {0, 0}, {-2, 0}, {1, 0}, {-2, -1}, {1, 2} },//0->1
	        { {0, 0}, {-1, 0}, {2, 0}, {-1, 2}, {2, -1} },      //1->2
	        { {0, 0}, {2, 0}, {-1, 0}, {2, 1}, {-1, -2} },   //2->3
	        { {0, 0}, {1, 0}, {-2, 0}, {1, -2}, {-2, 1} } //3->0
	};
	//I블록 반시계방향 회전
	private final int [][][] reversRotationWallKickDateI = {
	         { {0, 0}, {-1, 0}, {2, 0}, {-1, 2}, {2, -1} },    //0->3
	         { {0, 0}, {2, 0}, {-1, 0}, {2, 1}, {-1, -2} },     //1->0
	         { {0, 0}, {1, 0}, {-2, 0}, {1, -2}, {-2, 1} },     //2->1
	         { {0, 0}, {-2, 0}, {1, 0}, {-2, -1}, {1, 2} },    //3->2
	};
	
	public MoveBlock(Board board) {this.board = board;}
	public boolean canMove(Block block) {
		for(int[] part: block.getShape()) {
			int x = block.getX() + part[0];
			int y = block.getY() + part[1];
			if(x < 0 || x >= Board.GAME_BOARD_WIDTH || y<0 || y >= Board.GAME_BOARD_HEIGHT) {}
		}
		return true;
	}
	public boolean move(Block block, int dx, int dy) {
		//이동불가할 시 원위치로 돌아와라
		block.setX(block.getX() + dx);
		block.setY(block.getY() + dy);
		
		return true;
	}
	public boolean moveRight(Block block) {return move(block, -1,0);}

}

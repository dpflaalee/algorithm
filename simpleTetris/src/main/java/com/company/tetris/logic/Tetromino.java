package com.company.tetris.logic;

//모양, 이동
public class Tetromino {
	private Point[] shape;
	private Point position;
	private char type;
	
	public Tetromino (char type) {
		this.type = type; 
		this.position=new Point(4,0); //중앙 상단
		this.shape = generateShape(type);
	}
	
    private Point[] generateShape(char type) {
        switch (type) {
            case 'I': return new Point[]{ new Point(-1,0), new Point(0,0), new Point(1,0), new Point(2,0) };
            case 'O': return new Point[]{ new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1) };
            case 'T': return new Point[]{ new Point(-1,0), new Point(0,0), new Point(1,0), new Point(0,1) };
            case 'S': return new Point[]{ new Point(0,0), new Point(1,0), new Point(-1,1), new Point(0,1) };
            case 'Z': return new Point[]{ new Point(-1,0), new Point(0,0), new Point(0,1), new Point(1,1) };
            case 'J': return new Point[]{ new Point(-1,0), new Point(0,0), new Point(1,0), new Point(-1,1) };
            case 'L': return new Point[]{ new Point(-1,0), new Point(0,0), new Point(1,0), new Point(1,1) };
            default: return new Point[]{ new Point(0,0) };
        }
    }
	
	public Point[] getAbsoluteBlocks() {
		Point[] result = new Point[shape.length];
		for(int i = 0; i<shape.length; i++) {
			result[i] = new Point(position.x + shape[i].x, position.y + shape[i].y);
		}
		return result;
	}
	
	public void move(int dx, int dy) {
		position.x += dx;
		position.y += dy;
	}
	
	public void rotateClockwise() {
		for(int i = 0; i<shape.length; i++) {
			int x = shape[i].x;
			int y = shape[i].y;
			shape[i] = new Point(-y,x);
		}
//		for(Point p:shape) {
//			int temp = p.x;
//			p.x = -p.y;
//			p.y = temp;
//		}
	}
	
    public void rotateCounterClockwise() {
        for (int i = 0; i < shape.length; i++) {
            int x = shape[i].x;
            int y = shape[i].y;
            shape[i] = new Point(y, -x);
        }
    }
	
	public Point getPosition() {return position;}
	public void setPosition(Point p) {this.position = p;}
	public char getType() {return type;}
}

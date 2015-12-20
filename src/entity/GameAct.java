package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	private static final int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	private Point[] actPoints = null;
	private int typeCode;
	
	private static List<Point[]> TYPE_CONFIG;
	
	static {
		//TODO config
		TYPE_CONFIG = new ArrayList<Point[]>(7);
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(6,0)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(3,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(5,0),new Point(3,1),new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(5,0),new Point(4,1),new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(4,1),new Point(5,1)});
	}
	public GameAct(){
		
		this.init(0);
	}
	
	
	public int getTypeCode() {
		return this.typeCode;
	}


	public List<Point[]> getTYPE_CONFIG() {
		return TYPE_CONFIG;
	}


	public void init(int actCode){
		this.typeCode = actCode;
	    Point[] points = TYPE_CONFIG.get(typeCode);
	    actPoints = new Point[points.length];
		for(int i = 0; i < TYPE_CONFIG.get(actCode).length;i++){
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
		
			
	}
	
	public Point[] getActPoints() {
		return actPoints;
	}
	
	public boolean move(int moveX, int moveY, boolean[][] gameMap) {
		// check boundary
		if (canMove(moveX, moveY, gameMap)) {
			// move action
			for (int i = 0; i < actPoints.length; i++) {
				int newX = actPoints[i].x + moveX;
				int newY = actPoints[i].y + moveY;
				actPoints[i].x = newX;
				actPoints[i].y = newY;
			}
			return true;
		}else{
			return false;
		}
	}

	public void rotate(boolean[][] gameMap) {
		if(typeCode == 4)
			return;
		if (canRotate(gameMap)) {
			// Rotate the blocks
			for (int i = 1; i < actPoints.length; i++) {
				int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
				int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
				// TODO check if it can be rotated
				actPoints[i].x = newX;
				actPoints[i].y = newY;
			}
		}
	}
	
	private boolean canMove(int moveX, int moveY, boolean[][] gameMap){
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			// check if it is over map or overlaps the existed blocks
			if (newX < MIN_X || newX >MAX_X || newY<MIN_Y || newY >MAX_Y || gameMap[newX][newY]==true) {
				return false;
			}
		
		}
		return true;
	}
	
	private boolean canRotate(boolean[][] gameMap){
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x-actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x+actPoints[i].x;
			// check if it is over map or overlaps the existed blocks
			if (newX < MIN_X || newX >MAX_X || newY<MIN_Y || newY >MAX_Y || gameMap[newX][newY]==true) {
				return false;
			}
		
		}
		return true;
	}
	
	

}

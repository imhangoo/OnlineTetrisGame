package dto;

import java.util.List;

import entity.BlockShape;
import entity.GameMap;

public class GameDto {
	private List<Player> dbRecord;
	private List<Player> diskRecord;
	private boolean[][] gameMap;
	private BlockShape shape;
	private int next;
	private int currentLevel;
	private int currentPoint;
	private int currentRemovedLine;
	private boolean gameAlive = true;
	
	public boolean isGameAlive() {
		return gameAlive;
	}

	public void setGameAlive(boolean gameAlive) {
		this.gameAlive = gameAlive;
	}

	public List<Player> getDbRecord() {
		return dbRecord;
	}
	
	public GameDto(){
		dtoInit();
	}
	
	public void dtoInit(){
		this.gameMap = new GameMap().getGameMap();
	}
	
	public void setDbRecord(List<Player> dbRecord) {
		this.dbRecord = dbRecord;
	}
	public List<Player> getDiskRecord() {
		return diskRecord;
	}
	public void setDiskRecord(List<Player> diskRecord) {
		this.diskRecord = diskRecord;
	}
	public boolean[][] getGameMap() {
		return gameMap;
	}
	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}
	public BlockShape getBlockShape() {
		return shape;
	}
	public void setGameAct(BlockShape shape) {
		this.shape = shape;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	public int getCurrentPoint() {
		return currentPoint;
	}
	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}
	public int getCurrentRemovedLine() {
		return currentRemovedLine;
	}
	public void setCurrentRemovedLine(int currentRemovedLine) {
		this.currentRemovedLine = currentRemovedLine;
	}
	

}

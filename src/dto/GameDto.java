package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	private List<Player> dbRecord;
	private List<Player> diskRecord;
	private boolean[][] gameMap;
	private GameAct gameAct;
	private int next;
	private int currentLevel;
	private int currentPoint;
	private int currentRemovedLine;
	
	public List<Player> getDbRecord() {
		return dbRecord;
	}
	
	public GameDto(){
		dtoInit();
	}
	
	public void dtoInit(){
		//TODO hard code
		this.gameMap = new boolean[10][18];
		//TODO initialize all game objects
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
	public GameAct getGameAct() {
		return gameAct;
	}
	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
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

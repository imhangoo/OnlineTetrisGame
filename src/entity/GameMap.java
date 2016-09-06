package entity;

public class GameMap {
	private boolean[][] gameMap;
	
	public GameMap(){
		this.gameMap = new boolean[10][18];
	}
	
	public boolean[][] getGameMap(){
		return gameMap;
	}

}

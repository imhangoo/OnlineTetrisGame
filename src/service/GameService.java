package service;


import java.awt.Point;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import dto.GameDto;
import entity.BlockShape;

public class GameService {
	private GameDto dto;
	// get gameMap object
	private boolean map[][] = null; 
	private Random random = new Random();
	private static final int MAX_TYPE = 6;
	
	public GameService(GameDto dto) {
		this.dto = dto;
		BlockShape act = new BlockShape();
		dto.setGameAct(act);
		map = this.dto.getGameMap();
		this.dto.setNext(random.nextInt(MAX_TYPE));

	}

	public void keyLeft() {
		this.dto.getBlockShape().move(-1, 0, map);

	}

	public void keyUp() {
		this.dto.getBlockShape().rotate(map);

	}

	public void keyDown() {
		
		// check if the block can move down
		// if yes, no action to map
		if(this.dto.getBlockShape().move(0, 1, map)){
			return;
		}
		
		// if not, update map
		Point[] act = this.dto.getBlockShape().getActPoints();
		// add active blocks to map
		addBlocksToMap(act);
		// row elimination
		rowEliminate(act);
		
		// TODO score calculation
		// TODO judge if there is level change
		// TODO level improve
		
		//  refresh a new block
		this.dto.getBlockShape().init(dto.getNext());
		this.dto.setNext(random.nextInt(MAX_TYPE));

	}

	public boolean checkAlive() {
		return this.dto.isGameAlive();
		
	}

	public void keyRight() {
		this.dto.getBlockShape().move(1, 0, map);

	}
	
	public void addBlocksToMap(Point[] act){
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
	}
	public void rowEliminate(Point[] act){
		// get possible full lines
		Set<Integer> lines = new TreeSet<Integer>();
		for (int i = 0; i < act.length; i++) {
			if(act[i].y == 0){
				this.dto.setGameAlive(false); 
				return;
			}
			lines.add(act[i].y);
		}
		
		// check each possible line full or not
		for(Integer line:lines){
			boolean flag = true;
			for(int i = 0; i < 10; i++){
				if(map[i][line] == false){
					flag = false;
				}
			}
			// if not full, check next line
			if(!flag) continue;
			
			// if full  
			// removed lines and point increment 
			int currentRemovedLines = dto.getCurrentRemovedLine();
			int currentPoint = dto.getCurrentPoint();
			int currentLevel = dto.getCurrentLevel();
			dto.setCurrentRemovedLine(currentRemovedLines + 1);
			dto.setCurrentPoint(currentPoint+10);
			if((currentRemovedLines+1)%5==0){
				dto.setCurrentLevel(currentLevel+1);
			}
			
			// move down all lines above the full line
			for(int j = line; j > 0; j--){
				for(int i = 0; i < 10; i++){
					map[i][j] = map[i][j-1];
				}
			}
		}
		
	}

	public void test() {
		int currentRemovedLines = dto.getCurrentRemovedLine();
		int currentPoint = dto.getCurrentPoint();
		int currentLevel = dto.getCurrentLevel();
		dto.setCurrentRemovedLine(currentRemovedLines + 1);
		dto.setCurrentPoint(currentPoint+10);
		if((currentRemovedLines+1)%5==0){
			dto.setCurrentLevel(currentLevel+1);
		}
		
	}
	
	
}



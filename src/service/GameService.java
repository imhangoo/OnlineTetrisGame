package service;


import java.awt.Point;
import java.util.Random;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	private GameDto dto;
	// get gameMap object
	private boolean map[][] = null; 
	private Random random = new Random();
	private static final int MAX_TYPE = 6;
	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct();
		dto.setGameAct(act);
		map = this.dto.getGameMap();
		this.dto.setNext(random.nextInt(MAX_TYPE));

	}

	public void keyLeft() {
		this.dto.getGameAct().move(-1, 0, map);

	}

	public void keyUp() {
		this.dto.getGameAct().rotate(map);

	}

	public void keyDown() {
		
		// check if the block can move down
		if(this.dto.getGameAct().move(0, 1, map)){
			return;
		}
		
		Point[] act = this.dto.getGameAct().getActPoints();
		// add the block to map
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		
		// TODO check if there is row elimination
		// TODO row elimination
		// TODO score calculation
		// TODO judge if there is level change
		// TODO level improve
		//  refresh a new block
		
		this.dto.getGameAct().init(dto.getNext());
		this.dto.setNext(random.nextInt(MAX_TYPE));

	}

	public void keyRight() {
		this.dto.getGameAct().move(1, 0, map);

	}

}

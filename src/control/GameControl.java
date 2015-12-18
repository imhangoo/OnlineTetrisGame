package control;

import service.GameService;
import ui.JPanelGame;

/*
 * receive player keyboard events
 * control ui
 * control game service
 * 
 */
public class GameControl {
	// Game interface layer
	private JPanelGame panelGame;
	// Game logic layer
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame = panelGame;
		this.gameService = gameService;
	}
	


	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
		
	}

	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
		
	}

	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
		
	}

	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
		
	}

}

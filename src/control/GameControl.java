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
	//
	AutoDownThread autoDownThreadRunnable;

	public GameControl(JPanelGame panelGame, GameService gameService) {
		this.panelGame = panelGame;
		this.gameService = gameService;
		autoDownThreadRunnable = new AutoDownThread(this);
		autoDown();
	}

	public void resumeOrSuspend() {
		autoDownThreadRunnable.resumeOrSuspend();
	}

	// block shape auto falling down thread
	public void autoDown() {
		Thread autoDownThread = new Thread(autoDownThreadRunnable);
		autoDownThread.start();

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
		if(!this.gameService.checkAlive()){
			gameOver();
		}
		this.panelGame.repaint();

	}

	private void gameOver() {
		autoDownThreadRunnable.setAlive(false);
		
	}

	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();

	}

	public void test() {
		this.gameService.test();
		this.panelGame.repaint();
		
	}

}

class AutoDownThread implements Runnable {
	private GameControl gameControl;
	// game state, run or suspend
	private boolean suspend = false;
	// falling time interval, milliseconds
	private int interval = 1000;
	// game alive
	private boolean gameAlive = true;
	
	public void setAlive(boolean alive){
		this.gameAlive = alive;
	}

	public AutoDownThread(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	public void run() {
		while (gameAlive) {
			gameControl.keyDown();
			try {
				Thread.sleep(interval);
				synchronized(this){
					while (suspend) {
						this.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	// pause auto falling
	public void suspend(){
		suspend = true;
	}
	
	// resume auto falling
	public void resume(){
		suspend = false;
		synchronized(this){
			this.notify();
		}
	}
	
	public void resumeOrSuspend(){
		if(suspend){
			resume();
		}else{
			suspend();
		}
	}

}

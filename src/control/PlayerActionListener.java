package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerActionListener extends KeyAdapter{
	private GameControl gameControl;
	
	public PlayerActionListener(GameControl gameControl){
		this.gameControl = gameControl;
	}


    // Key press event
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			this.gameControl.keyUp();
			break;
		case KeyEvent.VK_DOWN:
			this.gameControl.keyDown();
			break;
		case KeyEvent.VK_LEFT:
			this.gameControl.keyLeft();
		    break;
		case KeyEvent.VK_RIGHT:
			this.gameControl.keyRight();
			break;
		case KeyEvent.VK_SPACE:
			this.gameControl.resumeOrSuspend();
			break;
		case KeyEvent.VK_Q:
			this.gameControl.test();
			break;
		default:
			break;
		}
	}


}

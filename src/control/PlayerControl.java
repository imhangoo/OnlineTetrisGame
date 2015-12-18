package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl extends KeyAdapter{
	private GameControl gameControl;
	
	public PlayerControl(GameControl gameControl){
		this.gameControl = gameControl;
	}


    // Key press event
	@Override
	public void keyPressed(KeyEvent e) {
		//TODO this way of listing is not good
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
		default:
			break;
		}
	}


}

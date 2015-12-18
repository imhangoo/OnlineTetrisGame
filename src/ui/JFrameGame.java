package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame {
	public JFrameGame(JPanelGame panelGame){
		// get game config
		GameConfig cfg = ConfigFactory.getGameConfig();
		// Set title
		this.setTitle(cfg.getTitle());
		// Set default close attribute
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set Frame Size
		this.setSize(cfg.getWidth(),cfg.getHeight());
		// Prevent user from changing frame size
		this.setResizable(false);
		// Set frame in the center
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth())/2;
		int y = (screen.height - this.getHeight())/2-19;
		this.setLocation(x,y);
		//Set default Panel
		this.setContentPane(panelGame);
		this.setVisible(true);
	}

}

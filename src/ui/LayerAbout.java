package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerAbout extends Layer {
	
	public LayerAbout(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	// title image
		private static Image IMG_LOGO = new ImageIcon("Graphics/string/logo.png").getImage(); 
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_LOGO, this.x+50, this.y+25, null);
	}

}
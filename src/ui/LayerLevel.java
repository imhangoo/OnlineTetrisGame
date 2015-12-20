package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer {
	
	private int level;
	public LayerLevel(int x, int y, int w, int h){
		super(x, y, w, h);
		
	}
	
	// title image
	private static Image IMG_LEVEL = new ImageIcon("Graphics/string/level.png").getImage(); 
	
	
	
	public void paint(Graphics g){
		this.level = this.dto.getCurrentLevel();
		this.createWindow(g);
		g.drawImage(IMG_LEVEL, this.x+SIZE+(this.w-IMG_LEVEL.getWidth(null) >>1), this.y+PADDING, null);
		String strNum = Integer.toString(level);
		int digits = strNum.length();
		int centreX =  this.w - digits * NUMBER_WIDTH >> 1;
		drawNumber(centreX,60,level,  g);
	}
	
	

}
package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer {
	
	public LayerLevel(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	// title image
	private static Image IMG_LEVEL = new ImageIcon("Graphics/string/level.png").getImage(); 
	// number image
	private static Image IMG_NUMBER = new ImageIcon("Graphics/string/number.png").getImage(); 
	private static final int NUMBER_WIDTH = 26;
	private static final int NUMBER_HEIGHT = 26;
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_LEVEL, this.x+PADDING, this.y+PADDING, null);
		drawNumber(72, 62, 13,  g);
	}
	
	private void drawNumber(int x, int y, int num, Graphics g){
		int nextInteger = num % 10;
		int digit = 0;
		while (num != 0) {
			num = num / 10;
			g.drawImage(IMG_NUMBER, this.x + x-digit*26, this.y + y, this.x + x + NUMBER_WIDTH-digit*26, this.y + y + NUMBER_HEIGHT,
					nextInteger * NUMBER_WIDTH, 0, (nextInteger + 1) * NUMBER_WIDTH, NUMBER_HEIGHT, null);
			nextInteger = num % 10;
			digit++;
		}
	}

}
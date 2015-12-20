package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {
	
	public LayerPoint(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	// title image
	private final Image IMG_POINT = new ImageIcon("Graphics/string/point.png").getImage(); 
	private static Image IMG_RMLINE = new ImageIcon("Graphics/string/rmline.png").getImage(); 
	
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_POINT, this.x+PADDING, this.y+PADDING, null);
		g.drawImage(IMG_RMLINE, this.x+PADDING, this.y+this.IMG_POINT.getHeight(null)+(PADDING<<1), null);
		drawNumber(this.IMG_POINT.getWidth(null)+(PADDING<<3),PADDING,this.dto.getCurrentPoint(),  g);
		drawNumber(this.IMG_POINT.getWidth(null)+(PADDING<<3),this.IMG_POINT.getHeight(null)+(PADDING<<1),this.dto.getCurrentRemovedLine(),  g);
	}

}
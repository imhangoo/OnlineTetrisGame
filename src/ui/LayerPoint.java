package ui;

import java.awt.Color;
import java.awt.Font;
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
	private int imageX = this.x+PADDING;
	private int numberX = this.IMG_POINT.getWidth(null)+(PADDING<<3);
	private int ptY = this.y+PADDING;
	private int rmY = this.y+this.IMG_POINT.getHeight(null)+(PADDING<<1);
	private int rmNumberY = this.IMG_POINT.getHeight(null)+(PADDING<<1);
	private int rectY = this.y+110;
	private int rectWidth = 300;
	private int rectHeight = 35;
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_POINT, imageX, ptY, null);
		g.drawImage(IMG_RMLINE, imageX, rmY, null);
		drawNumber(numberX,PADDING,this.dto.getCurrentPoint(),  g);
		drawNumber(numberX,rmNumberY,this.dto.getCurrentRemovedLine(),  g);
		g.setColor(Color.BLACK);
		g.fillRect(imageX, rectY, rectWidth, rectHeight);
		g.setColor(Color.WHITE);
		g.fillRect(imageX+1, rectY+1, rectWidth-2, rectHeight-2);
		g.setColor(Color.BLACK);
		g.fillRect(imageX+2, rectY+2, rectWidth-4, rectHeight-4);
		g.setColor(Color.CYAN);
		g.fillRect(imageX+2, rectY+2, rectWidth*(dto.getCurrentRemovedLine()%5)/5, rectHeight-4);
	}

}
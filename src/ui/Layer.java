package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import dto.GameDto;

/**
 * Draw a window
 * @author Administrator
 *
 */
public abstract class Layer {
	/**
	 * Top-left x of this window
	 */
	protected int x;
	/**
	 * Top-left y of this window
	 */
	protected int y;
	/**
	 * Inner width this window
	 */
	protected int w;
	/**
	 * Inner height of this window
	 */
	protected int h;
	protected static final int PADDING = 16;
	protected static final int SIZE = 7;
	protected static Image WINDOW_IMG = new ImageIcon("Graphics/window/Window.png").getImage();
	/**
	 * Constructor
	 */
	protected GameDto dto =null;
	protected Layer(int x, int y, int w, int h){
		this.x =x;
		this.y =y;
		this.w =w;
		this.h =h;
		
	}
	
	/**
	 * Draw this window
	 */
	protected void createWindow(Graphics g){
		g.drawImage(WINDOW_IMG, x,y,x+SIZE,y+SIZE, 0, 0, SIZE, SIZE, null);
		g.drawImage(WINDOW_IMG,x+SIZE,y,x+SIZE+w,y+SIZE, SIZE, 0, SIZE+1, SIZE, null);
		g.drawImage(WINDOW_IMG,x+SIZE+w,y,x+SIZE+w+SIZE,y+SIZE, 57, 0, SIZE+57, SIZE, null);
		g.drawImage(WINDOW_IMG,x,y+SIZE,x+SIZE,y+SIZE+h, 0, SIZE, SIZE, SIZE+1, null);
		g.drawImage(WINDOW_IMG,x,y+SIZE+h,x+SIZE,y+SIZE+h+SIZE, 0, 57, SIZE, 57+SIZE, null);
		g.drawImage(WINDOW_IMG,x+SIZE,y+SIZE+h,x+SIZE+w,y+SIZE+SIZE+h, SIZE, 57, SIZE+1, 57+SIZE, null);
		g.drawImage(WINDOW_IMG,x+SIZE+w,y+SIZE+h,x+SIZE+w+SIZE,y+SIZE+h+SIZE, 57, 57, SIZE+57, SIZE+57, null);
		g.drawImage(WINDOW_IMG,x+SIZE+w,y+SIZE,x+SIZE+SIZE+w,y+SIZE+h, 57, SIZE, 57+SIZE, 1+SIZE, null);
		g.drawImage(WINDOW_IMG,x+SIZE,y+SIZE,x+SIZE+w,y+SIZE+h, SIZE, SIZE, 57, 57, null);
		
	}
	
	abstract public void paint(Graphics g);

	public void setDto(GameDto dto) {
		this.dto = dto;
	}


}

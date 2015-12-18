package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class LayerNext extends Layer {
	private static final Image[] NEXT_ACT;
	static{
		NEXT_ACT = new Image[7];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] =  new ImageIcon("Graphics/game/"+i+".png").getImage();
		}
	}
	
	private static final int ACT_SIZE_ROL = 5;
	public LayerNext(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		int next = this.dto.getNext();
		this.drawImageaAtCentre(NEXT_ACT[next], g);
		
	}
	
	// draw image at centre
	private void drawImageaAtCentre(Image img, Graphics g){
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		int imgX = this.x +7 +( this.w - imgW >> 1);
		int imgY = this.y +7+ ( this.h - imgH >> 1);
		g.drawImage(img, imgX, imgY, null);
	}
	
	

}
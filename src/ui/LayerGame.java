package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class LayerGame extends Layer {

	// TODO CONFIG
	private static Image ACT = new ImageIcon("Graphics/game/rect.png").getImage();
	private static int ACT_SIZE_ROL = 5;
	private boolean[][] map;
	

	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		Point[] points = this.dto.getGameAct().getActPoints();
        int typeCode = this.dto.getGameAct().getTypeCode();
		// print blocks
		for (int i = 0; i < points.length; ++i) {
			drawSquareByPoint(points[i].x, points[i].y, g, typeCode+1);
		}

		this.map = this.dto.getGameMap();
		// print current map
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j]) {
					drawSquareByPoint(i, j, g, 0);
				}
			}
		}
		

	}
	
	// draw a single active square block
	public void drawSquareByPoint(int x ,int y, Graphics g, int imgIdx){
		g.drawImage(ACT, this.x + (x << ACT_SIZE_ROL) + 7, this.y + (y << ACT_SIZE_ROL) + 7,
				this.x + ((x + 1) << ACT_SIZE_ROL) + 7, this.y + ((y + 1) << ACT_SIZE_ROL) + 7,
				imgIdx << ACT_SIZE_ROL, 0, imgIdx+1 << ACT_SIZE_ROL, 1 << ACT_SIZE_ROL, null);
	}
	
	
}
package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerDisk extends Layer {
	
	public LayerDisk(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	private static Image IMG_DISK = new ImageIcon("Graphics/string/disk.png").getImage(); 
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_DISK, this.x+PADDING, this.y+PADDING, null);
	}

}
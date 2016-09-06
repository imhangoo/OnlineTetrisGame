package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
import control.GameControl;
import control.PlayerActionListener;
import dto.GameDto;
import service.GameService;


public class JPanelGame extends JPanel {
	
	
	private GameDto dto = null;
	private List<Layer> layers = null;

	public JPanelGame(GameDto dto){
		// get dto object
		this.dto = dto;
		// Components initialization
		initComponents();
		//Layer initialization
		initLayer();

	}
	
	private void initComponents(){
		
		
	}
	/*
	 * install palyer controller
	 */
	public void setGameControl(PlayerActionListener control){
		this.addKeyListener(control);
	}
	
	private void initLayer(){
		try {
			//Get game config
			GameConfig cfg = ConfigFactory.getGameConfig();
			// get layers config
			List<LayerConfig> layersCfg = cfg.getLayersConfig();
			// create layers arrays
			layers = new ArrayList<Layer>(layersCfg.size());
			// create all layer objects
			for (LayerConfig layerCfg : layersCfg){
				// get class object
				Class<?> cls = Class.forName(layerCfg.getClassName());
				// get constructor
				Constructor<?> ctr = cls.getConstructor(int.class,int.class,int.class,int.class);
				//call constructor and create an object
				Layer layer = (Layer)ctr.newInstance(
					layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
					);
				// Set game data object
				layer.setDto(this.dto);
				//add layer object into layers list
								layers.add(layer);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		// call father class method
		super.paintComponent(g);
		// Loop refresh windows
		for (int i = 0; i < layers.size(); layers.get(i++).paint(g));
		// return focus
		this.requestFocus();
		
}
}

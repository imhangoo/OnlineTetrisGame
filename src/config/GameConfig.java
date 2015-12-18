package config;

import java.util.ArrayList;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig{
	private String title;
	private int width;
	private int height;
	private int windowSize;
	private int padding;
	
	private List<LayerConfig> layersConfig;
	
	/**
	 * Constructor
	 * Read xml file and get entire game config
	 * @throws Exception
	 */
	public GameConfig() throws Exception {
		// Create a XML reader
		SAXReader reader = new SAXReader();
		// Read from a XML file
		Document doc = reader.read("config/cfg.xml");
		// Get the root node of XML file
		Element game = doc.getRootElement();
		
		// Set window configuration
		this.setUiConfig(game.element("frame"));
		// Set system configuration
		this.setSystemConfig(game.element("system"));
		// Set system data
		this.setSystemData(game.element("data"));

	}

	/**
	 *  Configuration Window
	 * @param frame Window Configuration elements 
	 */
	
	public void setUiConfig(Element frame){
		this.title = frame.attributeValue("title");
		this.width = Integer.parseInt(frame.attributeValue("width"));
		this.height = Integer.parseInt(frame.attributeValue("height"));
		this.windowSize = Integer.parseInt(frame.attributeValue("windowSize"));
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		
		List<Element> layers = frame.elements("layer");
		String str = frame.attributeValue("width");
		layersConfig = new ArrayList<LayerConfig>();
		for(Element layer: layers){
			LayerConfig lc = new LayerConfig(
					layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("x")),
					Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")),
					Integer.parseInt(layer.attributeValue("h"))
					);
			
			layersConfig.add(lc);
		}
	}
	
	
	public void setSystemConfig(Element sys){
		//TODO system parameter configuration
	}
	
	
	public void setSystemData(Element data){
		//TODO
	}

	public String getTitle() {
		return title;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getWindowSize() {
		return windowSize;
	}

	public int getPadding() {
		return padding;
	}

	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}
	
	
}

package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

/**
 * This is the main function.
 * @author Hangoo imhangoos
 *
 */
public class Main {
	public static void main(String[] args){
		// Data source
		GameDto dto = new GameDto();
		// Create game panel
		JPanelGame panel = new JPanelGame(dto);
		// create game logic(connect game data source)
		GameService service = new GameService(dto);
		// create game controller(connect game panel and game logics)
		GameControl gameControl = new GameControl(panel,service);
		// create player controller(connect to game controller)
		PlayerControl control = new PlayerControl(gameControl);
		// Install player controller
		panel.setGameControl(control);
		// create game window, install game panels
		JFrameGame jf = new JFrameGame(panel);
		
	}

}

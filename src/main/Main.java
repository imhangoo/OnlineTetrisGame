package main;

import control.GameControl;
import control.PlayerActionListener;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

/**
 * This is the main function.
 * @author imhangoo
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
		// create player action listener( connect to game controller)
		PlayerActionListener listener = new PlayerActionListener(gameControl);
		// Install player action listener
		panel.setGameControl(listener);
		// create game window, install game panels
		JFrameGame jf = new JFrameGame(panel);
		
	}

}

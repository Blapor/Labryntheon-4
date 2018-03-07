package maze.states;

/**
*
* @author Ryan
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import maze.Button;
import maze.Character;
import maze.Main;
import static maze.Main.height;
import static maze.Main.width;
import maze.Player;

public class CreditsState extends State{
	
	private Button saveButton;
	private Button loadButton;
	private Button toMenuButton;
	private Button backButton;
	private Button saveAndQuitButton;
	private Player player;
    private Character pc;
	
	public CreditsState(Main main){
        super(main);
        player = main.getPlayer();
        pc = main.getCharacter();
        saveButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/5, 256,64, "Save Game");
        loadButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/4, 256,64, "Load Previous Save");
        saveAndQuitButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/3, 256,64, "Save and Quit");
        backButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/2, 256,64, "Exit Without Saving");
    }
	
    @Override
    public void update() {
        saveButton.update((int)player.getMouseX(), (int)player.getMouseY());
        loadButton.update((int)player.getMouseX(), (int)player.getMouseY());
        saveAndQuitButton.update((int)player.getMouseX(), (int)player.getMouseY());
        backButton.update((int)player.getMouseX(), (int)player.getMouseY());
        
        if(easyButton.click(player.getLeftPressed())){
            pc.setdifficulty(0);
            State.setState(main.getGameState());
        }
        if(mediumButton.click(player.getLeftPressed())){
            pc.setdifficulty(1);
            State.setState(main.getGameState());
        }
        if(hardButton.click(player.getLeftPressed())){
            pc.setdifficulty(2);
            State.setState(main.getGameState());
        }
        if(MLGButton.click(player.getLeftPressed())){
            pc.setdifficulty(3);
            State.setState(main.getGameState());
        }
        if(backButton.click(player.getLeftPressed())){
            State.setState(State.getLastState());
        }
    }
    
}

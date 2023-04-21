package controller.fxml;

import java.util.ArrayList;
import java.util.List;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.screen.EnableFullScreenCommand;
import controller.command.sound.PlayClipCommand;
import controller.command.sound.SwitchToMatchThemeCommand;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * 
 * The MainMenu class represents the main menu of the game and manages its
 * functionality.
 * 
 * @author gerardocipriano
 * @version 2.0
 */
public class MainMenu {

    /**
     * 
     * The button for accessing the settings.
     */
    @FXML
    private Button settingsButton;
    /**
     * 
     * The button for accessing the rules.
     */
    @FXML
    private Button rulesButton;
    /**
     * 
     * The button for accessing the decks.
     */
    @FXML
    private Button decksButton;
    /**
     * 
     * The button for accessing the match.
     */
    @FXML
    private Button matchButton;

    /**
     * 
     * Initializes the functionality of the buttons.
     * 
     * Each button has its own set of commands that are executed when it is clicked.
     */
    public void initialize() {

        settingsButton.setOnAction(event -> {
            List<IButtonCommand> settingsCommands = new ArrayList<>();
            settingsCommands.add(new PlayClipCommand());
            settingsCommands.add(new ChangeSceneCommand("Settings.fxml"));
            MacroCommand settingsMacro = new MacroCommand(settingsCommands);
            settingsMacro.execute();
        });

        rulesButton.setOnAction(event -> {
            List<IButtonCommand> rulesCommands = new ArrayList<>();
            rulesCommands.add(new PlayClipCommand());
            rulesCommands.add(new ChangeSceneCommand("Rules.fxml"));
            MacroCommand rulesMacro = new MacroCommand(rulesCommands);
            rulesMacro.execute();
        });

        decksButton.setOnAction(event -> {
            List<IButtonCommand> decksCommands = new ArrayList<>();
            decksCommands.add(new PlayClipCommand());
            decksCommands.add(new ChangeSceneCommand("Decks.fxml"));
            MacroCommand decksMacro = new MacroCommand(decksCommands);
            decksMacro.execute();
        });

        matchButton.setOnAction(event -> {
            List<IButtonCommand> matchCommands = new ArrayList<>();
            matchCommands.add(new PlayClipCommand());
            matchCommands.add(new EnableFullScreenCommand());
            matchCommands.add(new ChangeSceneCommand("Match.fxml"));
            matchCommands.add(new SwitchToMatchThemeCommand());
            MacroCommand matchMacro = new MacroCommand(matchCommands);
            matchMacro.execute();
        });
    }
}
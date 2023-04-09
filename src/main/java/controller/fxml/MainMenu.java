package controller.fxml;
import java.util.ArrayList;
import java.util.List;

import controller.command.ButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.screen.EnableFullScreenCommand;
import controller.command.sound.PlayClipCommand;
import controller.command.sound.SwitchToMatchThemeCommand;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MainMenu {

    @FXML
    private Button settingsButton;

    @FXML
    private Button rulesButton;

    @FXML
    private Button decksButton;

    @FXML
    private Button matchButton;


    public void initialize() {
        

        settingsButton.setOnAction(event -> {
            List<ButtonCommand> settingsCommands = new ArrayList<>();
            settingsCommands.add(new ChangeSceneCommand("Settings.fxml"));
            settingsCommands.add(new PlayClipCommand());
            MacroCommand settingsMacro = new MacroCommand(settingsCommands);
            settingsMacro.execute();
        });

        rulesButton.setOnAction(event -> {
            List<ButtonCommand> rulesCommands = new ArrayList<>();
            rulesCommands.add(new ChangeSceneCommand("Rules.fxml"));
            rulesCommands.add(new PlayClipCommand());
            MacroCommand rulesMacro = new MacroCommand(rulesCommands);
            rulesMacro.execute();
        });

        decksButton.setOnAction(event -> {
            List<ButtonCommand> decksCommands = new ArrayList<>();
            decksCommands.add(new ChangeSceneCommand("Decks.fxml"));
            decksCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(decksCommands);
            decksMacro.execute();
        });

        matchButton.setOnAction(event -> {
            List<ButtonCommand> matchCommands = new ArrayList<>();
            matchCommands.add(new ChangeSceneCommand("Match.fxml"));
            matchCommands.add(new PlayClipCommand());
            matchCommands.add(new EnableFullScreenCommand());
            matchCommands.add(new SwitchToMatchThemeCommand());
            MacroCommand matchMacro = new MacroCommand(matchCommands);
            matchMacro.execute();
        });
    }
}
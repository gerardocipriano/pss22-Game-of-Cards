package controller.fxml;
import java.util.ArrayList;
import java.util.List;

import controller.button.ActivateFullScreenCommand;
import controller.button.ChangeSceneCommand;
import controller.button.ButtonCommand;
import controller.button.MacroCommand;
import controller.button.PlayClipCommand;
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
            // Passa l'istanza della classe SceneHandler al costruttore della classe ChangeSceneCommand
            settingsCommands.add(new ChangeSceneCommand("Settings.fxml"));
            // Passa l'istanza della classe ButtonClipSound al costruttore della classe PlayClipCommand
            settingsCommands.add(new PlayClipCommand());
            MacroCommand settingsMacro = new MacroCommand(settingsCommands);
            settingsMacro.execute();
        });

        rulesButton.setOnAction(event -> {
            List<ButtonCommand> rulesCommands = new ArrayList<>();
            // Passa l'istanza della classe SceneHandler al costruttore della classe ChangeSceneCommand
            rulesCommands.add(new ChangeSceneCommand("Rules.fxml"));
            // Passa l'istanza della classe ButtonClipSound al costruttore della classe PlayClipCommand
            rulesCommands.add(new PlayClipCommand());
            MacroCommand rulesMacro = new MacroCommand(rulesCommands);
            rulesMacro.execute();
        });

        decksButton.setOnAction(event -> {
            List<ButtonCommand> decksCommands = new ArrayList<>();
            // Passa l'istanza della classe SceneHandler al costruttore della classe ChangeSceneCommand
            decksCommands.add(new ChangeSceneCommand("Decks.fxml"));
            // Passa l'istanza della classe ButtonClipSound al costruttore della classe PlayClipCommand
            decksCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(decksCommands);
            decksMacro.execute();
        });

        matchButton.setOnAction(event -> {
            List<ButtonCommand> matchCommands = new ArrayList<>();
            // Passa l'istanza della classe SceneHandler al costruttore della classe ChangeSceneCommand
            matchCommands.add(new ChangeSceneCommand("Match.fxml"));
            // Passa l'istanza della classe ButtonClipSound al costruttore della classe PlayClipCommand
            matchCommands.add(new PlayClipCommand());
            // Passa l'istanza della classe FullScreenManager al costruttore della classe ActivateFullScreenCommand
            matchCommands.add(new ActivateFullScreenCommand());
            MacroCommand matchMacro = new MacroCommand(matchCommands);
            matchMacro.execute();
        });
    }
}
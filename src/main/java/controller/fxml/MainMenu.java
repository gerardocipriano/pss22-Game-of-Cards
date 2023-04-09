package controller.fxml;
import java.util.ArrayList;
import java.util.List;

import controller.button.ActivateFullScreenCommand;
import controller.button.ChangeSceneCommand;
import controller.button.ButtonCommand;
import controller.button.MacroCommand;
import controller.button.PlayClipCommand;
import controller.screen.FullScreenManager;
import controller.sound.ButtonClipSound;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainMenu {

    private final SceneHandler sceneHandler = SceneHandler.getInstance();
    private FullScreenManager fullScreenManager;
    private ButtonClipSound buttonClipSound;

    @FXML
    private Button settingsButton;

    @FXML
    private Button rulesButton;

    @FXML
    private Button decksButton;

    @FXML
    private Button matchButton;


    public void initialize() {


        // Crea un'istanza della classe ButtonClipSound
        buttonClipSound = ButtonClipSound.getInstance();

        settingsButton.setOnAction(event -> {
            List<ButtonCommand> settingsCommands = new ArrayList<>();
            // Passa l'istanza della classe SceneHandler al costruttore della classe ChangeSceneCommand
            settingsCommands.add(new ChangeSceneCommand("Settings.fxml", sceneHandler));
            // Passa l'istanza della classe ButtonClipSound al costruttore della classe PlayClipCommand
            settingsCommands.add(new PlayClipCommand(buttonClipSound));
            MacroCommand settingsMacro = new MacroCommand(settingsCommands);
            settingsMacro.execute();
        });

        rulesButton.setOnAction(event -> {
            List<ButtonCommand> rulesCommands = new ArrayList<>();
            // Passa l'istanza della classe SceneHandler al costruttore della classe ChangeSceneCommand
            rulesCommands.add(new ChangeSceneCommand("Rules.fxml", sceneHandler));
            // Passa l'istanza della classe ButtonClipSound al costruttore della classe PlayClipCommand
            rulesCommands.add(new PlayClipCommand(buttonClipSound));
            MacroCommand rulesMacro = new MacroCommand(rulesCommands);
            rulesMacro.execute();
        });

        decksButton.setOnAction(event -> {
            List<ButtonCommand> decksCommands = new ArrayList<>();
            // Passa l'istanza della classe SceneHandler al costruttore della classe ChangeSceneCommand
            decksCommands.add(new ChangeSceneCommand("Decks.fxml", sceneHandler));
            // Passa l'istanza della classe ButtonClipSound al costruttore della classe PlayClipCommand
            decksCommands.add(new PlayClipCommand(buttonClipSound));
            MacroCommand decksMacro = new MacroCommand(decksCommands);
            decksMacro.execute();
        });

        matchButton.setOnAction(event -> {
            List<ButtonCommand> matchCommands = new ArrayList<>();
            // Passa l'istanza della classe SceneHandler al costruttore della classe ChangeSceneCommand
            matchCommands.add(new ChangeSceneCommand("Match.fxml", sceneHandler));
            // Passa l'istanza della classe ButtonClipSound al costruttore della classe PlayClipCommand
            matchCommands.add(new PlayClipCommand(buttonClipSound));
            // Passa l'istanza della classe FullScreenManager al costruttore della classe ActivateFullScreenCommand
            matchCommands.add(new ActivateFullScreenCommand(fullScreenManager));
            MacroCommand matchMacro = new MacroCommand(matchCommands);
            matchMacro.execute();
        });
    }
}
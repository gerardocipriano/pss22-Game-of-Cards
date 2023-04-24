package controller.fxml;


import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.screen.ToggleFullScreenCommand;
import controller.command.sound.PlayClipCommand;
import controller.command.sound.SwitchToMainThemeCommand;

import javafx.fxml.FXML;
import model.Deck;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import model.match.*;

public class Match {

    IMatchModel matchModel = MatchModel.getInstance();
    public static Deck selectedDeck = new Deck();
    @FXML
    private Button backButton;

    public void initialize() {
        backButton.setOnAction(event -> {
            List<IButtonCommand> matchCommands = new ArrayList<>();
            matchCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
            matchCommands.add(new PlayClipCommand());
            matchCommands.add(new ToggleFullScreenCommand());
            matchCommands.add(new SwitchToMainThemeCommand());
            MacroCommand matchMacro = new MacroCommand(matchCommands);
            matchMacro.execute();
        });
        // matchModel->start();
    }
}

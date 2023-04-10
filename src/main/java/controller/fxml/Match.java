package controller.fxml;

import java.util.ArrayList;
import java.util.List;

import controller.command.ButtonCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.screen.ToggleFullScreenCommand;
import controller.command.sound.PlayClipCommand;
import controller.command.sound.SwitchToMainThemeCommand;
import controller.command.MacroCommand;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Match {

    @FXML
    private Button backButton;

    public void initialize() {
        
        backButton.setOnAction(event -> {
            List<ButtonCommand> backCommands = new ArrayList<>();
            backCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
            backCommands.add(new PlayClipCommand());
            backCommands.add(new ToggleFullScreenCommand());
            backCommands.add(new SwitchToMainThemeCommand());
            MacroCommand settingsMacro = new MacroCommand(backCommands);
            settingsMacro.execute();
        });
    }

}



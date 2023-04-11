package controller.fxml;


import java.io.IOException;

import controller.fxml.SceneHandler;
import controller.sound.BackgroundMusic;
import controller.sound.SoundButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Deck;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.match.*;

public class Match implements Initializable {

    IMatchModel matchModel = MatchModel.getInstance();


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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BackgroundMusic.getInstance().playMainTheme();

        // matchModel->start();
    }
}

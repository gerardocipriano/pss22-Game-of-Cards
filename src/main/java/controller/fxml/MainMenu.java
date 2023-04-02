package controller.fxml;

import java.io.IOException;

import controller.sound.SoundButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.stage.Stage;

public class MainMenu {

    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private SoundButton settingsButton;

    @FXML
    private SoundButton rulesButton;

    @FXML
    void openSettings(final ActionEvent event) throws IOException {
        
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) settingsButton.getScene().getWindow());
        }
        sceneHandler.openSettings(event);
    }

    @FXML
    void openRules(final ActionEvent event) throws IOException {
        
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) rulesButton.getScene().getWindow());
        }
        sceneHandler.openRules(event);
    }

}
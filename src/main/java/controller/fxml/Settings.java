package controller.fxml;

import java.io.IOException;

import controller.screen.FullScreenManager;
import controller.sound.BackgroundMusic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class Settings {
    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private Button backButton;

    @FXML
    private Button toggleFullScreenButton;

    @FXML
    private Slider musicAudioLevelSlider;

    @FXML
    void backToMainMenu(final ActionEvent event) throws IOException {
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) backButton.getScene().getWindow());
        }
        sceneHandler.openMainMenu(event);
    }

    @FXML
    void toggleFullScreen(final ActionEvent event) throws IOException {
        FullScreenManager.getInstance((Stage) toggleFullScreenButton.getScene().getWindow()).toggleFullScreen();
    }

    public void initialize() {
        musicAudioLevelSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double volume = newValue.doubleValue() / 100;
            BackgroundMusic bgMusic = BackgroundMusic.getInstance();
            bgMusic.setVolume(volume);
        });
    }
}
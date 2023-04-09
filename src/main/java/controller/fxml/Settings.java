package controller.fxml;


import java.util.ArrayList;
import java.util.List;

import controller.button.ButtonCommand;
import controller.button.ChangeSceneCommand;
import controller.button.MacroCommand;
import controller.button.PlayClipCommand;
import controller.button.ToggleFullScreenCommand;
import controller.sound.BackgroundMusic;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class Settings {

    @FXML
    private Button backButton;

    @FXML Button toggleFullScreenButton;

    @FXML Slider musicAudioLevelSlider;

    public void initialize() {

        musicAudioLevelSlider.setValue(BackgroundMusic.getInstance().getVolume() * 100);
    
        musicAudioLevelSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double volume = newValue.doubleValue() / 100;
            BackgroundMusic.getInstance().setVolume(volume);
        });

        backButton.setOnAction(event -> {
            List<ButtonCommand> backCommands = new ArrayList<>();
            backCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
            backCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(backCommands);
            decksMacro.execute();
        });

        toggleFullScreenButton.setOnAction(event -> {
            List<ButtonCommand> backCommands = new ArrayList<>();
            backCommands.add(new ToggleFullScreenCommand());
            backCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(backCommands);
            decksMacro.execute();
        });
    }

    //Used for testing in the SettingsTest class
    public double getMusicAudioLevelSliderValue() {
        return musicAudioLevelSlider.getValue();
    }
}
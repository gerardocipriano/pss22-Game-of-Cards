package controller.fxml;


import java.util.ArrayList;
import java.util.List;

import controller.command.ButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.screen.ToggleFullScreenCommand;
import controller.command.sound.PlayClipCommand;
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
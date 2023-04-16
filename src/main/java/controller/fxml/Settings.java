package controller.fxml;


import java.util.ArrayList;
import java.util.List;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.screen.ToggleFullScreenCommand;
import controller.command.sound.PlayClipCommand;
import controller.sound.BackgroundMusicSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

/**
 * The Settings class represents the graphical user interface for the settings page of the application.
 * @author gerardocipriano
 */
public class Settings {

    /**
     * The button to go back to the previous page.
     */
    @FXML
    private Button backButton;

    /**
     * The button to toggle the full screen mode.
     */
    @FXML
    private Button toggleFullScreenButton;

    /**
     * The slider to adjust the music volume.
     */
    @FXML 
    private Slider musicAudioLevelSlider;

    /**
     * Initializes the settings page, setting the initial value of the music slider and adding change listeners to it.
     */
    public void initialize() {

        musicAudioLevelSlider.setValue(BackgroundMusicSingleton.getInstance().getVolume() * 100);

        musicAudioLevelSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double volume = newValue.doubleValue() / 100;
            BackgroundMusicSingleton.getInstance().setVolume(volume);
        });

        backButton.setOnAction(event -> {
            List<IButtonCommand> backCommands = new ArrayList<>();
            backCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
            backCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(backCommands);
            decksMacro.execute();
        });

        toggleFullScreenButton.setOnAction(event -> {
            List<IButtonCommand> backCommands = new ArrayList<>();
            backCommands.add(new ToggleFullScreenCommand());
            backCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(backCommands);
            decksMacro.execute();
        });
    }

    /**
     * Gets the value of the music slider for testing purposes.
     * 
     */
    public double getMusicAudioLevelSliderValue() {
        return musicAudioLevelSlider.getValue();
    }
    /**
     * Sets the value of the music slider for testing purposes.
     * 
     */
    public void setMusicAudioLevelSliderValue(double value) {
        musicAudioLevelSlider.setValue(value);
    }
}
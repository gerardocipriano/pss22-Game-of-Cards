package controller.fxml;

import java.util.ArrayList;
import java.util.List;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.screen.ToggleFullScreenCommand;
import controller.command.sound.PlayClipCommand;
import controller.sound.BackgroundMusicControllerMonostate;
import controller.sound.IBackgroundMusicController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import view.settings.ChoiceBoxView;

/**
 * The Settings class represents the graphical user interface for the settings
 * page of the application.
 * 
 * @author gerardocipriano
 */
public class Settings {
    @FXML
    private Button backButton;
    @FXML
    private Button toggleFullScreenButton;
    @FXML
    private Slider musicAudioLevelSlider;
    @FXML
    private ChoiceBox<String> choiceMainTheme;
    @FXML
    private ChoiceBox<String> choicheBattleTheme;

    private IBackgroundMusicController bgMusic;

    private ChoiceBoxView choiceBoxView;

    /**
     * Initializes the settings page, setting the initial value of the music slider
     * and adding change listeners to it.
     */
    public void initialize() {
        bgMusic = BackgroundMusicControllerMonostate.createInstance();

        musicAudioLevelSlider.setValue(bgMusic.getVolume() * 100);
        musicAudioLevelSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double volume = newValue.doubleValue() / 100;
            bgMusic.setVolume(volume);
        });

        choiceBoxView = new ChoiceBoxView(choiceMainTheme, choicheBattleTheme);
        choiceBoxView.populateChoiceBoxes();

        // restore the selected values when returning to this scene
        Platform.runLater(() -> {
            int currentMainThemeIndex = bgMusic.getCurrentMainThemeIndex();
            choiceMainTheme.getSelectionModel().select(currentMainThemeIndex);

            int currentMatchThemeIndex = bgMusic.getCurrentMatchThemeIndex();
            choicheBattleTheme.getSelectionModel().select(currentMatchThemeIndex);
        });

        choiceMainTheme.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int index = choiceMainTheme.getSelectionModel().getSelectedIndex();
            bgMusic.setCurrentMainThemeIndex(index);
            bgMusic.playMainTheme();
        });

        choicheBattleTheme.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int index = choicheBattleTheme.getSelectionModel().getSelectedIndex();
            bgMusic.setCurrentMatchThemeIndex(index);
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

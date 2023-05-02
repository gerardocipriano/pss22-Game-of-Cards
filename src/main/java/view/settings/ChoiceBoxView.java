package view.settings;

import controller.sound.BackgroundMusicControllerMonostate;
import controller.sound.IBackgroundMusicController;
import javafx.scene.control.ChoiceBox;
import javafx.scene.media.Media;

import java.util.List;

public class ChoiceBoxView {
    private ChoiceBox<String> choiceMainTheme;
    private ChoiceBox<String> choiceMatchTheme;
    private IBackgroundMusicController bgMusic = 
        BackgroundMusicControllerMonostate.createInstance();

    public ChoiceBoxView(ChoiceBox<String> choiceMainTheme, ChoiceBox<String> choiceMatchTheme) {
        this.choiceMainTheme = choiceMainTheme;
        this.choiceMatchTheme = choiceMatchTheme;
    }

    public void populateChoiceBoxes() {
        List<Media> mainThemes = bgMusic.getMainThemeMediaList();
        List<Media> matchThemes = bgMusic.getMatchThemeMediaList();
    
        if (mainThemes != null) {
            for (int i = 0; i < mainThemes.size(); i++) {
                String themeName = "Main Theme " + (i + 1);
                choiceMainTheme.getItems().add(themeName);
            }
            int currentMainThemeIndex = bgMusic.getCurrentMainThemeIndex();
            choiceMainTheme.getSelectionModel().select(currentMainThemeIndex);
        }
    
        if (matchThemes != null) {
            for (int i = 0; i < matchThemes.size(); i++) {
                String themeName = "Match Theme " + (i + 1);
                choiceMatchTheme.getItems().add(themeName);
            }
            int currentMatchThemeIndex = bgMusic.getCurrentMatchThemeIndex();
            choiceMatchTheme.getSelectionModel().select(currentMatchThemeIndex);
        }
    }
}

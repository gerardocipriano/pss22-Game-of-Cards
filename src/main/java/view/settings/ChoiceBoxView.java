package view.settings;

import controller.sound.AudioLoaderSingleton;
import controller.sound.BackgroundMusicSingleton;
import javafx.scene.control.ChoiceBox;
import javafx.scene.media.Media;

import java.util.List;

public class ChoiceBoxView {
    private ChoiceBox<String> choiceMainTheme;
    private ChoiceBox<String> choicheBattleTheme;

    public ChoiceBoxView(ChoiceBox<String> choiceMainTheme, ChoiceBox<String> choicheBattleTheme) {
        this.choiceMainTheme = choiceMainTheme;
        this.choicheBattleTheme = choicheBattleTheme;
    }

    public void populateChoiceBoxes() {
        List<Media> mainThemes = AudioLoaderSingleton.getInstance().getMainThemeMediaList();
        List<Media> matchThemes = AudioLoaderSingleton.getInstance().getMatchThemeMediaList();

        for (int i = 0; i < mainThemes.size(); i++) {
            String themeName = "Main Theme " + (i + 1);
            choiceMainTheme.getItems().add(themeName);
        }
        int currentMainThemeIndex = BackgroundMusicSingleton.getInstance().getCurrentMainThemeIndex();
        choiceMainTheme.getSelectionModel().select(currentMainThemeIndex);

        for (int i = 0; i < matchThemes.size(); i++) {
            String themeName = "Match Theme " + (i + 1);
            choicheBattleTheme.getItems().add(themeName);
        }
        int currentMatchThemeIndex = BackgroundMusicSingleton.getInstance().getCurrentMatchThemeIndex();
        choicheBattleTheme.getSelectionModel().select(currentMatchThemeIndex);
    }
}

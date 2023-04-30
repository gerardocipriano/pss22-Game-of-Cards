package controller.sound;

import exceptions.AudioLoadingException;
import exceptions.ErrorDialogHandler;
import javafx.application.Platform;
import javafx.scene.media.Media;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AudioLoaderSingleton {
    private static AudioLoaderSingleton instance;
    private List<Media> mainThemeMediaList;
    private List<Media> matchThemeMediaList;

    private AudioLoaderSingleton() {
        mainThemeMediaList = new ArrayList<>();
        matchThemeMediaList = new ArrayList<>();
        try {
            loadMainThemes();
            loadMatchThemes();
        } catch (AudioLoadingException e) {
            // displays an error message and exits the application
            ErrorDialogHandler errorDialogHandler = new ErrorDialogHandler();
            errorDialogHandler.showErrorDialog(e.getMessage() + " The application will now close.");
            Platform.exit();
        }
    }

    public static AudioLoaderSingleton getInstance() {
        if (instance == null) {
            instance = new AudioLoaderSingleton();
        }
        return instance;
    }

    private void loadMainThemes() throws AudioLoadingException {
        // Caricamento delle tracce audio dalla cartella delle risorse MainTheme
        File mainThemeFolder = new File(getClass().getResource("/sounds/music/MainThemes").getFile());
        for (File file : mainThemeFolder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".mp3")) {
                Media media = new Media(file.toURI().toString());
                mainThemeMediaList.add(media);
            }
        }
        if (mainThemeMediaList.isEmpty()) {
            throw new AudioLoadingException("Failed to load main theme audio resources.");
        }
    }

    private void loadMatchThemes() throws AudioLoadingException {
        // Caricamento delle tracce audio dalla cartella delle risorse MatchTheme
        File matchThemeFolder = new File(getClass().getResource("/sounds/music/MatchThemes").getFile());
        for (File file : matchThemeFolder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".mp3")) {
                Media media = new Media(file.toURI().toString());
                matchThemeMediaList.add(media);
            }
        }
        if (matchThemeMediaList.isEmpty()) {
            throw new AudioLoadingException("Failed to load match theme audio resources.");
        }
    }

    public void setCurrentMainThemeIndex(int index) {
        int currentMainThemeIndex = index;
    }
    
    public void setCurrentMatchThemeIndex(int index) {
        int currentMatchThemeIndex = index;
    }

    public List<Media> getMainThemeMediaList() {
        return mainThemeMediaList;
    }

    public List<Media> getMatchThemeMediaList() {
        return matchThemeMediaList;
    }
}
package controller.sound;

import exceptions.AudioLoadingException;
import exceptions.ErrorDialogHandler;
import javafx.application.Platform;
import javafx.scene.media.Media;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for loading audio tracks from specified folders.
 * It loads main theme audio tracks from the "/sounds/music/MainThemes" folder
 * and match theme audio tracks from the "/sounds/music/MatchThemes" folder.
 * The loaded audio tracks are stored in two separate lists and can be accessed
 * through the corresponding getter methods.
 *
 * @author gerardocipriano
 */
public class AudioLoader {
    private List<Media> mainThemeMediaList;
    private List<Media> matchThemeMediaList;

    /**
     * Constructor for the AudioLoader class.
     * It initializes the mainThemeMediaList and matchThemeMediaList and loads the
     * audio tracks from the specified folders.
     */
    public AudioLoader() {
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

    /**
     * Loads main theme audio tracks from the "/sounds/music/MainThemes" folder.
     *
     * @throws AudioLoadingException if no audio tracks are found in the specified
     *                               folder
     */
    private void loadMainThemes() throws AudioLoadingException {
        // Caricamento delle tracce audio dalla cartella delle risorse
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

    /**
     * Loads match theme audio tracks from the "/sounds/music/MatchThemes" folder.
     *
     * @throws AudioLoadingException if no audio tracks are found in the specified
     *                               folder
     */
    private void loadMatchThemes() throws AudioLoadingException {
        // Loading of the audio tracks from the MatchThemeFile
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

    /**
     * Returns a list of loaded main theme audio tracks.
     *
     * @return a list of loaded main theme audio tracks
     */
    public List<Media> getMainThemeMediaList() {
        return mainThemeMediaList;
    }

    /**
     * Returns a list of loaded match theme audio tracks.
     *
     * @return a list of loaded match theme audio tracks
     */
    public List<Media> getMatchThemeMediaList() {
        return matchThemeMediaList;
    }
}

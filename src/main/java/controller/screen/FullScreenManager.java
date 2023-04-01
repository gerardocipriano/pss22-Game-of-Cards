package controller.screen;

import javafx.stage.Stage;

public class FullScreenManager {
    private static FullScreenManager instance;
    private Stage stage;
    private boolean isFullScreen = false;

    private FullScreenManager(Stage stage) {
        this.stage = stage;
    }

    public static FullScreenManager getInstance(Stage stage) {
        if (instance == null) {
            instance = new FullScreenManager(stage);
        }
        return instance;
    }

    public void toggleFullScreen() {
        isFullScreen = !isFullScreen;
        stage.setFullScreen(isFullScreen);
    }
}
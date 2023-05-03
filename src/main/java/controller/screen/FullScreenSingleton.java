package controller.screen;

import javafx.stage.Stage;

public class FullScreenSingleton implements IFullScreenController {
    private static FullScreenSingleton instance;
    private Stage primaryStage;
    private boolean isFullScreen = false;

    private FullScreenSingleton() {}

    public static FullScreenSingleton getInstance() {
        if (instance == null) {
            instance = new FullScreenSingleton();
        }
        return instance;
    }

    /**
     * Sets the primary stage for this scene handler.
     *
     * @param primaryStage the primary stage
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void toggleFullScreen() {
        isFullScreen = !isFullScreen;
        primaryStage.setFullScreen(isFullScreen);
    }

    public boolean isFullScreen() {
        return isFullScreen;
    }
}
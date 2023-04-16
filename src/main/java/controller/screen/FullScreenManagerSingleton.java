package controller.screen;

import javafx.stage.Stage;

public class FullScreenManagerSingleton implements IFullScreenManagerController {
    private static FullScreenManagerSingleton instance;
    private Stage primaryStage;
    private boolean isFullScreen = false;

    private FullScreenManagerSingleton() {}

    public static FullScreenManagerSingleton getInstance() {
        if (instance == null) {
            instance = new FullScreenManagerSingleton();
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
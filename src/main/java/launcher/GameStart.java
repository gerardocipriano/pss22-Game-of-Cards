package launcher;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.fxml.SceneHandler;
import controller.screen.FullScreenManager;
import controller.sound.*;

/**
 * This class sets up the GUI for the Main Menu of the application.
 */
public final class GameStart extends Application {
    /**
     * 
     */
    public static final String SEPARATOR = "/";
    private static final int SCENE_WIDTH = 1280;
    private static final int SCENE_HEIGHT = 720;
    /**
     * This method loads the Menu and sets the window up.
     * 
     * @param stage the loaded stage.
     */
    public void start(final Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/MainMenuGui.fxml"));
        final Parent root = loader.load();
        final Scene scene = new Scene(root);
    
        SceneHandler.getInstance().setPrimaryStage(stage);
        FullScreenManager.getInstance().setPrimaryStage(stage);
    
        stage.getIcons().add(new Image("/images/logo.png"));
        stage.setScene(scene);
        stage.setTitle("Game of Cards");
        stage.setResizable(true);
        stage.setWidth(SCENE_WIDTH);
        stage.setHeight(SCENE_HEIGHT);
        stage.setAlwaysOnTop(true);
        stage.show();
        stage.setResizable(false);
        BackgroundMusic.getInstance().playMainTheme();
        BackgroundMusic.getInstance().setVolume(0.025);
    }
    /**
     * Main method.
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        launch();
    }
}

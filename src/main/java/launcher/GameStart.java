package launcher;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.sound.*;;

/**
 * This class sets up the GUI for the Main Menu of the application.
 */
public final class GameStart extends Application {
    /**
     * 
     */
    public static final String SEPARATOR = "/";
    private static final int SCENE_WIDTH = 1920;
    private static final int SCENE_HEIGHT = 1080;
    private final Stage primaryStage = new Stage();
    /**
     * This method loads the Menu and sets the window up.
     * 
     * @param stage the loaded stage.
     */
    public void start(final Stage stage) throws IOException {
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/MainMenuGui.fxml"));
        final Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.getIcons().add(new Image("/images/logo.png"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Cards");
        primaryStage.setResizable(true);
        primaryStage.show();
        primaryStage.setResizable(false);
        BackgroundMusic.getInstance().play();
        BackgroundMusic.getInstance().setVolume(0.1);
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

package launcher;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.screen.WindowConfigurator;
import controller.sound.BackgroundMusicSingleton;
import controller.sound.IBackgroundMusicController;

/**
 * This class sets up the GUI for the Main Menu of the application.
 * 
 * Controller Class
 */
public final class GameStart extends Application {

    private final WindowConfigurator windowConfigurator;

    /**
     * Constructs a new GameStart object.
     */
    public GameStart() {
        this.windowConfigurator = new WindowConfigurator();
    }

    /**
     * Starts the application.
     * @param stage the primary stage for this application
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void start(final Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/MainMenuGui.fxml"));
        final Parent root = loader.load();
        final Scene scene = new Scene(root);

        windowConfigurator.configure(stage);
        stage.setScene(scene);
        stage.show();
        
        IBackgroundMusicController bgMusic = BackgroundMusicSingleton.getInstance();
        bgMusic.play("main");
        bgMusic.setVolume(0.025);
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

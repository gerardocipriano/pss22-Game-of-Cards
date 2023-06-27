package launcher;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.screen.StageInitializer;
import controller.sound.AudioInitializer;

/**
 * This class sets up the GUI for the Main Menu of the application.
 * 
 * Controller Class
 */
public final class GameStart extends Application {

    private final StageInitializer stageInitializer;

    /**
     * Constructs a new GameStart object.
     */
    public GameStart() {
        this.stageInitializer = new StageInitializer();
    }

    /**
     * Starts the application.
     * 
     * @param stage the primary stage for this application
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void start(final Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/MainMenuGui.fxml"));
        final Parent root = loader.load();
        final Scene scene = new Scene(root);

        stageInitializer.configureStage(stage);
        stage.setScene(scene);
        stage.show();

        AudioInitializer.initializeAudio();
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

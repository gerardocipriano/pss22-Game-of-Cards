
package controller.match;



import java.io.IOException;


import org.testfx.framework.junit5.ApplicationTest;


import controller.fxml.Match;
import controller.sound.BackgroundMusicSingleton;
import controller.sound.IBackgroundMusicController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Test class for the Settings controller.
 */
public class MatchTest extends ApplicationTest {
    private Match matchController;

    /**
     * Set up the test environment by loading the "Settings" scene and getting its
     * controller.
     *
     * @param stage the primary stage for this test
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the "Settings" scene and get its controller
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/SettingsGui.fxml"));
        Parent root = loader.load();
        matchController = loader.getController();

        IBackgroundMusicController bgMusic = BackgroundMusicSingleton.getInstance();
        bgMusic.play("main");
        bgMusic.setVolume(0.025);

        // Set the scene and show the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

}

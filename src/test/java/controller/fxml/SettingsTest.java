package controller.fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

import controller.screen.FullScreenManager;
import controller.sound.*;
/**
 * Test class for the Settings controller.
 */
public class SettingsTest extends ApplicationTest {
    private Settings settingsController;

    /**
     * Set up the test environment by loading the "Settings" scene and getting its controller.
     *
     * @param stage the primary stage for this test
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the "Settings" scene and get its controller
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/SettingsGui.fxml"));
        Parent root = loader.load();
        settingsController = loader.getController();

        SceneHandler.getInstance().setPrimaryStage(stage);
        FullScreenManager.getInstance().setPrimaryStage(stage);

        BackgroundMusic.getInstance().playMainTheme();
        BackgroundMusic.getInstance().setVolume(0.5);

        // Set the scene and show the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    /**
     * Test the musicAudioLevelSlider by simulating a drag of the slider to change its value and verifying that its value has changed and that the music volume has changed accordingly.
     */
    @Test
    public void testMusicAudioLevelSlider() {
        // Get the current value of the slider
        double oldValue = settingsController.getMusicAudioLevelSliderValue();
        settingsController.musicAudioLevelSlider.setValue(0);
        // Simulate a drag of the slider to change its value
        drag("#musicAudioLevelSlider").dropBy(20, 0);

        // Verify that the value of the slider has changed
        double newValue = settingsController.getMusicAudioLevelSliderValue();
        assertNotEquals(oldValue, newValue);

        // Verify that the music volume has changed accordingly
        BackgroundMusic bgMusic = BackgroundMusic.getInstance();
        assertEquals(newValue / 100, bgMusic.getVolume(), 0.01);
    }
    /**
     * Test the backToMainMenu method by simulating a click on the "backButton" and verifying that the current scene changes to "MainMenu".
     */
    @Test
    public void testBackToMainMenu() {
        // Simulate a click on the "backButton"
        clickOn("#backButton");

        // Verify that the current scene has changed to "MainMenu"
        FxAssert.verifyThat("#settingsButton", LabeledMatchers.hasText("Settings"));
    }

    /**
     * Test the toggleFullScreen method by simulating a click on the "toggleFullScreenButton" and verifying that the stage is in full screen mode or not depending on its previous state.
     */
    @Test
    public void testToggleFullScreen() {
        // Get the current full screen state of the stage
        FullScreenManager fullScreenManager = FullScreenManager.getInstance();
        boolean oldState = fullScreenManager.isFullScreen();
    
        // Simulate a click on the "toggleFullScreenButton"
        clickOn("#toggleFullScreenButton");
    
        // Verify that the full screen state of the stage has changed
        boolean newState = fullScreenManager.isFullScreen();
        assertNotEquals(oldState, newState);
    }


}
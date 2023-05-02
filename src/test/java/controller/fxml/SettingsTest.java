package controller.fxml;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import view.screen.WindowConfigurator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import controller.screen.FullScreenManagerSingleton;
import controller.screen.IFullScreenManagerController;
import controller.sound.*;

/**
 * Test class for the Settings controller.
 * 
 * @author gerardocipriano
 */
public class SettingsTest extends ApplicationTest {

    private Settings settingsController;
    private final WindowConfigurator windowConfigurator = new WindowConfigurator();
    private IBackgroundMusicController bgMusic = BackgroundMusicControllerMonostate.createInstance();
    private IFullScreenManagerController fullScreenManager = FullScreenManagerSingleton.getInstance();

    @BeforeAll
    public static void initToolkit() {
        // Initializes the JavaFX toolkit
        new JFXPanel();
    }

    @Override
    public void start(Stage stage) throws IOException {

        // Load the "Settings" scene and get its controller
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/SettingsGui.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Set the scene and show the stage
        windowConfigurator.configure(stage);
        AudioInitializer.initializeAudio();
        stage.setScene(scene);
        stage.show();
        settingsController = loader.getController();
    }

    /**
     * Test the musicAudioLevelSlider by simulating a drag of the slider to change
     * its value and verifying that its value has changed and that the music volume
     * has changed accordingly.
     */
    @Test
    public void testMusicAudioLevelSlider() {
        // Get the current value of the slider
        double oldValue = settingsController.getMusicAudioLevelSliderValue();
        settingsController.setMusicAudioLevelSliderValue(50);
        // Simulate a drag of the slider to change its value
        drag("#musicAudioLevelSlider").dropBy(40, 0);

        // Verify that the value of the slider has changed
        double newValue = settingsController.getMusicAudioLevelSliderValue();
        assertNotEquals(oldValue, newValue);

        // Verify that the music volume has changed accordingly
        assertEquals(newValue / 100, bgMusic.getVolume(), 0.01);
    }

    @Test
    public void testChoiceBox() throws InterruptedException {
        assertNotNull(settingsController.getChoiceMainTheme());
        assertNotNull(settingsController.getChoiceMatchTheme());
        clickOn("#choiceMainTheme");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        assertEquals(1, settingsController.getChoiceMainTheme().getSelectionModel().getSelectedIndex());

        clickOn("#choiceMatchTheme");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        assertEquals(1, settingsController.getChoiceMainTheme().getSelectionModel().getSelectedIndex());
    }

    /**
     * Test the backToMainMenu method by simulating a click on the "backButton" and
     * verifying that the current scene changes to "MainMenu".
     */
    @Test
    public void testBackToMainMenu() {
        // Simulate a click on the "backButton"
        clickOn("#backButton");

        // Verify that the current scene has changed to "MainMenu"
        FxAssert.verifyThat("#settingsButton", LabeledMatchers.hasText("Settings"));
    }

    /**
     * Test the toggleFullScreen method by simulating a click on the
     * "toggleFullScreenButton" and verifying that the stage is in full screen mode
     * or not depending on its previous state.
     */
    @Test
    public void testToggleFullScreen() {

        // Get the current full screen state of the stage
        boolean oldState = fullScreenManager.isFullScreen();

        // Simulate a click on the "toggleFullScreenButton"
        clickOn("#toggleFullScreenButton");

        // Verify that the full screen state of the stage has changed
        boolean newState = fullScreenManager.isFullScreen();
        assertNotEquals(oldState, newState);
    }

}

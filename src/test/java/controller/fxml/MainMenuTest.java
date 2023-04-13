package controller.fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import controller.screen.FullScreenManager;
import controller.sound.BackgroundMusic;

import java.io.IOException;
/**
 * 
 * The MainMenuTest class contains the test for the main menu class
 * 
 * @author gerardocipriano
 */
public class MainMenuTest extends ApplicationTest {

    /**
     * Set up the test environment by loading the "MainMenu" scene and getting its controller.
     *
     * @param stage the primary stage for this test
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the "MainMenu" scene and get its controller
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/MainMenuGui.fxml"));
        Parent root = loader.load();

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

    @Test
    public void testSettingsButton() {
        // Click on the settings button
        clickOn("#settingsButton");
        
        // Verify that the current scene has changed to "Settings"
        FxAssert.verifyThat("#toggleFullScreenButton", LabeledMatchers.hasText("Enable/Disable"));
    }
    
    @Test
    public void testRulesButton() {
        // Click on the rules button
        clickOn("#rulesButton");
        
        // Verify that the back button is present
        FxAssert.verifyThat("#backButton", LabeledMatchers.hasText("Back"));
    }
    
    @Test
    public void testDecksButton() {
        // Click on the decks button
        clickOn("#decksButton");
        
        // Verify that the back button is present
        FxAssert.verifyThat("#backButton", LabeledMatchers.hasText("Back"));
    }
    
    @Test
    public void testMatchButton() {
        // Click on the match button
        clickOn("#matchButton");
        
        // Verify that the back button is present
        FxAssert.verifyThat("#backButton", LabeledMatchers.hasText("Back"));
    }
}
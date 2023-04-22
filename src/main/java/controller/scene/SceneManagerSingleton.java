package controller.scene;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import view.screen.StageSizeTracker;

import java.io.IOException;

import exceptions.ErrorDialogHandler;
import exceptions.UnsupportedResolutionException;

/**
 * This class is a Singleton that handle the scenes of the game.
 * It have methods to open different scenes and to set and get the primary stage.
 * @author gerardocipriano
 */
public class SceneManagerSingleton implements ISceneManagerController {
    private static SceneManagerSingleton instance;
    private Stage primaryStage;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private SceneManagerSingleton() {}

    /**
     * Get the instance of the SceneManagerSingleton.
     * @return The instance of the SceneManagerSingleton.
     */
    public static SceneManagerSingleton getInstance() {
        if (instance == null) {
            instance = new SceneManagerSingleton();
        }
        return instance;
    }

    /**
     * Set the primary stage of the game.
     * @param primaryStage The primary stage to set.
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Get the primary stage of the game.
     * @return The primary stage of the game.
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Open the settings scene.
     * @param event The ActionEvent that triggered this method.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public void openSettings(ActionEvent event) throws IOException {
        loadScene("layouts/SettingsGui.fxml");
    }

    /**
     * Open the main menu scene.
     * @param event The ActionEvent that triggered this method.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public void openMainMenu(ActionEvent event) throws IOException {
        loadScene("layouts/MainMenuGui.fxml");
    }

    /**
     * Open the card creation scene.
     * @param event The ActionEvent that triggered this method.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public void openCardCreation(ActionEvent event) throws IOException {
        loadScene("path/to/CardCreationGui.fxml");
    }

    /**
     * Open the deck management scene.
     * @param event The ActionEvent that triggered this method.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public void openDeckManagement(ActionEvent event) throws IOException {
        loadScene("layouts/DeckManagementGui.fxml");
    }

/**
 * Opens the match scene. If the screen resolution is not supported, an error message is shown to the user and the application is closed.
 * @param event The event that triggered this method.
 * @throws IOException If an error occurs while loading the FXML file for the match scene.
 */
public void openMatch(ActionEvent event) throws IOException {
    try {
        MatchSceneSelector selector = new MatchSceneSelector();
        double screenWidth = StageSizeTracker.getStageWidth();
        double screenHeight = StageSizeTracker.getStageHeight();
        String fxmlPath = selector.getMatchSceneFxmlPath(screenWidth, screenHeight);
        loadScene(fxmlPath);
    } catch (UnsupportedResolutionException e) {
        // Show an error dialog to the user with the message from the exception
        ErrorDialogHandler errorHandler = new ErrorDialogHandler();
        errorHandler.showErrorDialog(e.getMessage());
        // Close the application
        Platform.exit();
    }
}

    /**
     * Open the rules scene.
     * @param event The ActionEvent that triggered this method.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public void openRules(ActionEvent event) throws IOException {
        loadScene("layouts/RulesGui.fxml");
    }

    /**
     * Load a new scene from an FXML file and display it on the primary stage.
     * @param fxmlPath The path of the FXML file to load.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public void loadScene(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(ClassLoader.getSystemResource(fxmlPath));
        primaryStage.getScene().setRoot(root);
        primaryStage.show();
    }
}
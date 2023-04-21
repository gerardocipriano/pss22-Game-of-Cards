package controller.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.screen.StageSizeTracker;

import java.io.IOException;

/**
 * This class is a Singleton that handle the scenes of the game.
 * It have methods to open different scenes and to set and get the primary stage.
 * @author gerardocipriano
 */
public class SceneManagerSingleton implements ISceneManagerController {
    private static SceneManagerSingleton instance;
    private Stage primaryStage;
    private double screenWidth;

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
     * Open the match scene.
     * @param event The ActionEvent that triggered this method.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public void openMatch(ActionEvent event) throws IOException {
        String fxmlPath;
    
        if (StageSizeTracker.getStageWidth() == 1920.0 && StageSizeTracker.getStageHeight() == 1080.0) {
            fxmlPath = "layouts/MatchGui1920x1080.fxml";
        } else {
            fxmlPath = "layouts/SettingsGui.fxml";
        }
        loadScene(fxmlPath);
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

    public void setScreenWidth(double screenWidth) {
        this.screenWidth = screenWidth;
    }
}
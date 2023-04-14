package controller.scene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * Interface for managing scenes in a JavaFX application.
 * @author gerardocipriano
 */
public interface ISceneManagerController {

    /**
     * Sets the primary stage for the application.
     * @param stage the primary stage
     */
    void setPrimaryStage(Stage stage);

    /**
     * Opens the settings scene.
     * @param event the action event that triggered this method
     * @throws IOException if an error occurs while loading the scene
     */
    void openSettings(ActionEvent event) throws IOException;

    /**
     * Opens the main menu scene.
     * @param event the action event that triggered this method
     * @throws IOException if an error occurs while loading the scene
     */
    void openMainMenu(ActionEvent event) throws IOException;

    /**
     * Opens the card creation scene.
     * @param event the action event that triggered this method
     * @throws IOException if an error occurs while loading the scene
     */
    void openCardCreation(ActionEvent event) throws IOException;

    /**
     * Opens the deck management scene.
     * @param event the action event that triggered this method
     * @throws IOException if an error occurs while loading the scene
     */
    void openDeckManagement(ActionEvent event) throws IOException;

    /**
     * Opens the match scene.
     * @param event the action event that triggered this method
     * @throws IOException if an error occurs while loading the scene
     */
    void openMatch(ActionEvent event) throws IOException;

    /**
     * Opens the rules scene.
     * @param event the action event that triggered this method
     * @throws IOException if an error occurs while loading the scene
     */
    void openRules(ActionEvent event) throws IOException;

    /**
     * Loads a scene from an FXML file.
     * @param fxmlPath the path to the FXML file
     * @throws IOException if an error occurs while loading the scene
     */
    void loadScene(String fxmlPath) throws IOException;
}

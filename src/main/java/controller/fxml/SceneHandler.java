package controller.fxml;

import java.io.IOException;

import controller.screen.FullScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class handles changing scenes using JavaFX and loading different layouts in FXML format.
 */
public class SceneHandler {
    private static SceneHandler instance;
    private Stage primaryStage;

    private SceneHandler() {}

    /**
     * Returns the singleton instance of the SceneHandler class.
     *
     * @return the singleton instance of the SceneHandler class
     */
    public static SceneHandler getInstance() {
        if (instance == null) {
            instance = new SceneHandler();
        }
        return instance;
    }

    /**
     * Sets the primary stage for this scene handler.
     *
     * @param primaryStage the primary stage
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Opens the settings scene.
     *
     * @param event the action event
     * @throws IOException if an I/O error occurs
     */
    public void openSettings(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/SettingsGui.fxml"));
        primaryStage.getScene().setRoot(root);
        primaryStage.show();
    }

    public void openMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/MainMenuGui.fxml"));
        primaryStage.getScene().setRoot(root);
        primaryStage.show();
    }
    

    /**
     * Opens the card creation scene.
     *
     * @param event the action event
     * @throws IOException if an I/O error occurs
     */
    public void openCardCreation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/path/to/CardCreation.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Opens the deck management scene.
     *
     * @param event the action event
     * @throws IOException if an I/O error occurs
     */
    public void openDeckManagement(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/path/to/DeckManagement.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Opens the match scene.
     *
     * @param event the action event
     * @throws IOException if an I/O error occurs
     */
    public void openMatch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/path/to/Match.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Opens the rules scene.
     *
     * @param event the action event
     * @throws IOException if an I/O error occurs
     */
    public void openRules(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/path/to/Rules.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void openMainMenu() {
    }
}
package controller.fxml;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import controller.sound.SoundButton;

/**
 * Controller for the Rules scene.
 */
public class Rules  {

    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private SoundButton backButton;

    @FXML
    private TabPane tabPane;

    /**
     * 
     * Initializes the controller.
     * 
     */
    public void initialize() {
        // Set the opacity of the content of all tabs to 0 at startup
        for (Tab tab : tabPane.getTabs()) {
            tab.getContent().setOpacity(0);
        }

        // Select the first tab
        selectFirstTab();

        // Add a listener to the selected item property of the tab pane
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) {
                // Create and play a fade out transition for the content of the previous tab
                FadeTransition fadeOut = new FadeTransition(Duration.millis(500), oldValue.getContent());
                fadeOut.setFromValue(1.0);
                fadeOut.setToValue(0.0);
                fadeOut.setOnFinished(event -> {
                    // Create and play a fade in transition for the content of the new tab
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newValue.getContent());
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();
                });
                fadeOut.play();
            } else {
                // Create and play a fade in transition for the content of the first tab
                FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newValue.getContent());
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            }
        });
    }

    /**
     * Selects the first tab.
     */
    public void selectFirstTab() {
        // Select the first tab
        tabPane.getSelectionModel().selectFirst();
    }

    /**
     * Handles the action of going back to the main menu.
     *
     * @param event the action event
     * @throws IOException if an I/O error occurs
     */
    @FXML
    void backToMainMenu(final ActionEvent event) throws IOException {
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) backButton.getScene().getWindow());
        }
        sceneHandler.openMainMenu(event);
    }
}
package controller.fxml;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.scene.control.TabPane;
import javafx.util.Duration;

public class Rules {
    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private Button returnButton;

    @FXML
    private TabPane tabPane;

    @FXML
    private void initialize() {
        tabPane.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            FadeTransition fadeOut = new FadeTransition(Duration.millis(500), tabPane.getTabs().get(oldValue.intValue()).getContent());
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(event -> {
                FadeTransition fadeIn = new FadeTransition(Duration.millis(500), tabPane.getTabs().get(newValue.intValue()).getContent());
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            });
            fadeOut.play();
        });
    }

    @FXML
    void backToMainMenu(final ActionEvent event) throws IOException {
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) returnButton.getScene().getWindow());
        }
        sceneHandler.openMainMenu(event);
    }
}

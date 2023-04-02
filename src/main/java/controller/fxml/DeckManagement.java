package controller.fxml;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeckManagement {
    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private Button returnButton;

    @FXML
    void backToMainMenu(final ActionEvent event) throws IOException {
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) returnButton.getScene().getWindow());
        }
        sceneHandler.openMainMenu(event);
    }
}

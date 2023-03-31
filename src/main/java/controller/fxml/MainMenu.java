package controller.fxml;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenu {

    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private Button settingsButton;

    @FXML
    void openSettings(final ActionEvent event) throws IOException {
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) settingsButton.getScene().getWindow());
        }
        sceneHandler.openSettings(event);
    }

}
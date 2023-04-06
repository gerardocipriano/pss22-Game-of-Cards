package controller.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DeckManagement implements Initializable {
    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private Button backButton;

    @FXML
    void backToMainMenu(final ActionEvent event) throws IOException {
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) backButton.getScene().getWindow());
        }
        sceneHandler.openMainMenu(event);
    }

    @FXML
    private ListView<String> rightlist;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rightlist.getItems().add("Carta 1");
        rightlist.getItems().add("Carta 2");
        rightlist.getItems().add("Carta 3");
    }
}

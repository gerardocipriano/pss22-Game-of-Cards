package controller.fxml;

import java.io.IOException;

import controller.fxml.SceneHandler;
import controller.sound.BackgroundMusic;
import controller.sound.SoundButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Deck;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.match.*;

public class Match implements Initializable {

    IMatchModel matchModel = MatchModel.getInstance();

    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private SoundButton backButton;

    @FXML
    void backToMainMenu(final ActionEvent event) throws IOException {
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) backButton.getScene().getWindow());
        }
        sceneHandler.openMainMenu(event);
        BackgroundMusic.getInstance().playMainTheme();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BackgroundMusic.getInstance().playMainTheme();

        // matchModel->start();
    }
}

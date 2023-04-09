package controller.fxml;

import java.io.IOException;

import controller.sound.BackgroundMusic;
import controller.sound.SoundButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Deck;

public class Match {

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

    void startMatch(Deck deck) {

        createGameBoard();

        getDeck();

        createPlayer1();
        createPlayer2();

    }

}

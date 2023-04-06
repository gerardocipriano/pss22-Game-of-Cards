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
import model.Card;

// Il controller implementa l'interfaccia Initializable la quale richiede
// che venga definito il metodo 'initialize' eseguito automaticamente
// quando il file FXML viene caricato 
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
    private ListView<Card> rightList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rightList.getItems().addAll(
            new Card("Carta 1", 10),
            new Card("Carta 2", 5),
            new Card("Carta 3", 8)
    );
    }
}

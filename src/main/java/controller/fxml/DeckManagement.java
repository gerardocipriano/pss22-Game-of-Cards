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
import model.deckmanagement.AddCell;
import model.deckmanagement.DeckCard;
import model.deckmanagement.DeleteCell;

public class DeckManagement implements Initializable {
    private final SceneHandler sceneHandler = SceneHandler.getInstance();
    
    @FXML
    private Button backButton;

    @FXML
    private ListView<DeckCard> rightList;

    @FXML
    private ListView<DeckCard> centerList;

    @FXML
        void backToMainMenu(final ActionEvent event) throws IOException {
            if (sceneHandler.getPrimaryStage() == null) {
                sceneHandler.setPrimaryStage((Stage) backButton.getScene().getWindow());
            }
            sceneHandler.openMainMenu(event);
        }
    
    @Override
        public void initialize(URL location, ResourceBundle resources) {
            rightList.setCellFactory(param -> new AddCell("Add", centerList)); 
            rightList.getItems().addAll(
                new DeckCard("Card 1", 10),
                new DeckCard("Card 2", 5),
                new DeckCard("Card 3", 8),
                new DeckCard("Card 4", 13),
                new DeckCard("Card 5", 20)
            );
            centerList.setCellFactory(param -> new DeleteCell("Remove", centerList));
        }

    
        
    
}
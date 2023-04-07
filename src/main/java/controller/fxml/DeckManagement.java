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
import model.Deck;
import model.deckmanagement.RightCell;
import model.deckmanagement.DeckCard;
import model.deckmanagement.LeftCell;
import model.deckmanagement.CenterCell;

public class DeckManagement implements Initializable {
    private final SceneHandler sceneHandler = SceneHandler.getInstance();
    
    @FXML
    private Button backButton;

    @FXML
    private ListView<DeckCard> rightList;

    @FXML
    private ListView<DeckCard> centerList;

    @FXML
    private ListView<Deck> leftList;

    @FXML
        void backToMainMenu(final ActionEvent event) throws IOException {
            if (sceneHandler.getPrimaryStage() == null) {
                sceneHandler.setPrimaryStage((Stage) backButton.getScene().getWindow());
            }
            sceneHandler.openMainMenu(event);
        }
    
    @FXML
        void saveDeck(final ActionEvent event) throws IOException{
            System.out.println("tastosavepremuto");
            Deck deck = new Deck();
            for ( DeckCard i : centerList.getItems()){
                deck.addCard(i);
            }
            leftList.getItems().add(deck);
        }
        
    @Override
        public void initialize(URL location, ResourceBundle resources) {
            rightList.setCellFactory(param -> new RightCell("Add", centerList)); 
            rightList.getItems().addAll(
                new DeckCard("Card 1", 10),
                new DeckCard("Card 2", 5),
                new DeckCard("Card 3", 8),
                new DeckCard("Card 4", 13),
                new DeckCard("Card 5", 20)
            );
            centerList.setCellFactory(param -> new CenterCell("Remove", centerList));
            leftList.setCellFactory(param -> new LeftCell("Remove", leftList));
        }   
}
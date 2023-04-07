package model.deckmanagement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import model.Deck;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DeckCell extends ListCell<Deck> {

    private VBox container;
    private Button deckButton;
    private Label label;

    public DeckCell(String buttonText, ListView<Deck> leftList ) {
        label = new Label();
        deckButton = new Button(buttonText);
        container = new VBox(label, deckButton);
        deckButton.setOnAction(e -> {
            Deck deck = getItem();
            this.handleCards(deck, leftList);
        });
    }
    
    protected void handleCards(Deck deck, ListView<Deck> leftList){
       leftList.getItems().remove(deck);
    }   

    protected void updateItem(Deck deck, boolean empty) {
        super.updateItem(deck, empty);
        if (empty || deck == null) {
            setGraphic(null);
        } else {
            label.setText(deck.toString());
            setGraphic(container);
        }
    }
}

package model.deckmanagement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import model.Deck;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DeckCell extends ListCell<Deck> {

    private VBox container;
    private Button deckButton;
    private Label label;
    private RadioButton radioButton;

    public DeckCell(String buttonText, ListView<Deck> leftList, ToggleGroup group  ) {
        label = new Label();
        deckButton = new Button(buttonText);
        radioButton = new RadioButton();
        radioButton.setText("Scegli");
        radioButton.setToggleGroup(group);
        container = new VBox(label, deckButton, radioButton);
        deckButton.setOnAction(e -> {
            Deck deck = getItem();
            this.handleDecks(deck, leftList);
        });
    }
    protected void handleDecks(Deck deck, ListView<Deck> leftList){
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

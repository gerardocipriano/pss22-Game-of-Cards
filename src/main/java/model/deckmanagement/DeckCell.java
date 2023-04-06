package model.deckmanagement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

abstract class DeckCell extends ListCell<DeckCard> {

    private VBox container;
    private Button cardButton ;
    private Label label;

    public DeckCell(String buttonText, ListView<DeckCard> centerList ) {
        label = new Label();
        cardButton = new Button(buttonText);
        container = new VBox(label, cardButton);
        cardButton.setOnAction(e -> {
            DeckCard card = getItem();
            this.handleCards(card, centerList);
        });
    }
    
    protected abstract void handleCards(DeckCard card, ListView<DeckCard> centerList);

    protected void updateItem(DeckCard card, boolean empty) {
        super.updateItem(card, empty);
        if (empty || card == null) {
            setGraphic(null);
        } else {
            label.setText(card.toString());
            setGraphic(container);
        }
    }
}
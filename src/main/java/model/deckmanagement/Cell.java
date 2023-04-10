package model.deckmanagement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import controller.command.sound.PlayClipCommand;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/*
 * Here i use the Template method design pattern to handle the cells of the listViews
 */
public abstract class Cell extends ListCell<DeckCard> {

    private VBox container;
    private Button cellButton ;
    private Label label;
    private PlayClipCommand playSound = new PlayClipCommand();

    public Cell(String buttonText, ListView<DeckCard> centerList ) {
        label = new Label();
        cellButton = new Button(buttonText);
        container = new VBox(label, cellButton);
        cellButton.setOnAction(e -> {
            playSound.execute();
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
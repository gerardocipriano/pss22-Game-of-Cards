package model.deckmanagement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Deck;
import controller.command.sound.PlayClipCommand;
import controller.fxml.Match;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/*
 * This class represents the cells in the list on the left side aka the Deck class,
 * being too different from the card cells a dedicated class was used
 */
public class DeckCell extends ListCell<Deck> {
    private Label label;
    private HBox buttonContainer;
    private VBox container;
    private Button showButton;
    private Button deleteButton;
    private RadioButton radioButton;
    private PlayClipCommand playSound = new PlayClipCommand();
    
    public DeckCell(ListView<Deck> leftList, ToggleGroup group  ) {
        label = new Label();
        showButton = new Button("Show");
        deleteButton = new Button("Delete");
        radioButton = new RadioButton("Select");
        radioButton.setToggleGroup(group);
        buttonContainer = new HBox(showButton, deleteButton);
        container = new VBox(label, buttonContainer, radioButton);

        showButton.setOnAction(e ->{
            playSound.execute();
        });
        deleteButton.setOnAction(e -> {
            playSound.execute();
            Deck deck = getItem();
            this.handleDecks(deck, leftList);
        });
        radioButton.setOnAction(e -> {
            Deck selectedDeck = getItem();
            Match.selectedDeck = selectedDeck;
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

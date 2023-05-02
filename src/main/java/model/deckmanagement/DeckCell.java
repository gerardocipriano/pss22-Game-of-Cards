package model.deckmanagement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Deck;
import utilities.parser.DeckParser;
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
        container.setPrefHeight(120);
        container.setPrefWidth(152);

        showButton.setOnAction(e ->{
            playSound.execute();
        });
        deleteButton.setOnAction(e -> {
            playSound.execute();
            Deck deck = getItem();
            this.handleDecks(deck, leftList);
            DeckParser.deleteDeck(deck);
        });
        radioButton.setOnAction(e -> {
            Match.selectedDeck = getItem();
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
            container.setBackground(new Background(new BackgroundImage(
                new Image(deck.getImage(), 120, 90, false, true),
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1, 1, true, true, false, false))));
            setGraphic(container);
        }
    }
}

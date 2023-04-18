package model.deckmanagement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import controller.command.sound.PlayClipCommand;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/*
 * This class represents a cell within the 2 listViews(center and right of the layout), given that each cell differs in some feature 
 * e.g. functionality and number of buttons, i implemented an abstract class that will be extended for each cell type (Template Method)
 */
public abstract class Cell extends ListCell<DeckCard> {

    private VBox container;
    private Button cellButton ;
    private Label label;
    private PlayClipCommand playSound = new PlayClipCommand();
    /* Each cell is created with a label and a button,
     * the button functionality is defined in the classes that extends this one (handleCards())
     */
    public Cell(String buttonText, ListView<DeckCard> centerList ) {
        label = new Label();
        cellButton = new Button(buttonText);
        label.toFront();
        container = new VBox(label, cellButton);
        cellButton.setOnAction(e -> {
            playSound.execute();
            DeckCard card = getItem();
            this.handleCards(card, centerList);
        });
        //container.setPadding(new Insets(5));
        container.setPrefHeight(100);
        container.setPrefWidth(150);
        container.setBackground(new Background(new javafx.scene.layout.BackgroundImage(
                new javafx.scene.image.Image("/images/Effect_Axe_1.jpg"),
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1, 1, true, true, false, false))));
    }
    
    protected abstract void handleCards(DeckCard card, ListView<DeckCard> centerList);
    
    /* updateItem() is a JavaFX built-in function that is called
     * everytime an item in the list is modified 
     */
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
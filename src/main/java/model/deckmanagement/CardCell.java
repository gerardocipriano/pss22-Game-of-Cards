package model.deckmanagement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import model.Card;

import java.util.ArrayList;
import java.util.List;

import controller.command.IButtonCommand;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/*
 * This class represents a cell within the 2 listViews(center and right of the layout), given that each cell differs in some feature 
 * e.g. functionality and number of buttons, i implemented an abstract class that will be extended for each cell type (Template Method)
 */
public class CardCell extends ListCell<Card> {

    protected VBox container;
    protected Button cellButton ;
    protected Label label;
    protected List<IButtonCommand> buttonCommands = new ArrayList<IButtonCommand>();
    protected Card card;
    /* Each cell is created with a label and a button,
     * the button functionality is defined in the classes that extends this one (handleCards())
     */
    public CardCell(ListView<Card> centerList) {
        label = new Label();
        cellButton = new Button("Move");
        label.toFront();
        container = new VBox(label, cellButton);
        container.setPrefHeight(120);
        container.setPrefWidth(152);
    }
    
    protected void updateItem(Card card, boolean empty) {
        super.updateItem(card, empty);
        if (empty || card == null) {
            setGraphic(null);
        } else {
            label.setText(card.toString());
            container.setBackground(new Background(new BackgroundImage(
                new Image(card.getImage(), 120, 90, false, true),
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1, 1, true, true, false, false))));
            setGraphic(container);
        }
    }
}
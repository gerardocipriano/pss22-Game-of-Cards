package model.deckmanagement;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Card;
import model.Deck;

public class CellFactory {
    private ToggleGroup group;
    private ListView<Deck> leftList;
    private ListView<Card> centerList;
    private TextField deckNameTextField;
    
    public CellFactory(ToggleGroup group, ListView<Deck> leftList, ListView<Card> centerList, TextField deckNameTextField) {
        this.group = group;
        this.leftList = leftList;
        this.centerList = centerList;
        this.deckNameTextField = deckNameTextField;
    }
    
    public DeckCell createDeckCell() {
        return new DeckCell(leftList, centerList, group, deckNameTextField);
    }
    
    public CardCell createCardCell() {
        return new CardCell(centerList);
    }
}

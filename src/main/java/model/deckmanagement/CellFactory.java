package model.deckmanagement;

import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import model.Card;
import model.Deck;

public class CellFactory {
    private ToggleGroup group;
    private ListView<Deck> leftList;
    private ListView<Card> centerList;
    
    public CellFactory(ToggleGroup group, ListView<Deck> leftList, ListView<Card> centerList) {
        this.group = group;
        this.leftList = leftList;
        this.centerList = centerList;
    }
    
    public DeckCell createDeckCell() {
        return new DeckCell(leftList, group);
    }
    
    public CardCell createCardCell() {
        return new CardCell(centerList);
    }
}

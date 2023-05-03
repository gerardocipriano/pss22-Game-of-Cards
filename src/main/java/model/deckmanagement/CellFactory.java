package model.deckmanagement;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Card;
import model.Deck;
/**
 * Create a custom Cell based on which listView is called with Factory pattern
 *
 * @author massimilianobattelli
 */
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
    /**
     * Create a Cell for the Deck
     */
    public DeckCell createDeckCell() {
        return new DeckCell(leftList, centerList, group, deckNameTextField);
    }
    /**
     * Create a Cell for the Card in the listView on the right
     */
    public CardCell createRightListCell() {
        return new RightListCell(centerList);
    }
    /**
     * Create a Cell for the Card in the listView on the center
     */
    public CardCell createCenterListCell() {
        return new CenterListCell(centerList);
    }
}

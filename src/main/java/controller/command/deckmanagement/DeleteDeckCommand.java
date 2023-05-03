package controller.command.deckmanagement;

import controller.command.IButtonCommand;
import javafx.scene.control.ListView;
import model.Deck;
import model.deckmanagement.DeckCell;
import utilities.parser.DeckParser;
/**
 * Class responsible for removing a Deck from the listView on the left of the screen and deleting it from the json file
 *
 * @author massimilianobattelli
 */
public class DeleteDeckCommand implements IButtonCommand {
    
    private ListView<Deck> leftList;
    private DeckCell deckCell;

    public DeleteDeckCommand(DeckCell deckCell, ListView<Deck> leftList) {
        this.deckCell = deckCell;
        this.leftList = leftList;
    }
    /**
     * Instruction to delete the deck, it uses {@link utilities.parser.DeckParser} to do it
     */
    @Override
    public void execute() {
        Deck deck = deckCell.getItem();
        leftList.getItems().remove(deck);
        DeckParser.deleteDeck(deck);
    }
    
}
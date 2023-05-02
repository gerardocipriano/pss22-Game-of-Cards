package controller.command.deckmanagement;

import controller.command.IButtonCommand;
import javafx.scene.control.ListView;
import model.Deck;
import model.deckmanagement.DeckCell;
import utilities.parser.DeckParser;

public class DeleteDeckCommand implements IButtonCommand {
    
    private ListView<Deck> leftList;
    private DeckCell deckCell;

    public DeleteDeckCommand(DeckCell deckCell, ListView<Deck> leftList) {
        this.deckCell = deckCell;
        this.leftList = leftList;
    }

    @Override
    public void execute() {
        Deck deck = deckCell.getItem();
        leftList.getItems().remove(deck);
        DeckParser.deleteDeck(deck);
    }
    
}
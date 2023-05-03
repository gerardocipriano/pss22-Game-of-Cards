package controller.command.deckmanagement;

import controller.command.IButtonCommand;
import controller.fxml.Match;
import model.deckmanagement.DeckCell;
/**
 * Class responsible for selecting the Deck to use in the game
 *
 * @author massimilianobattelli
 */
public class SelectDeckCommand implements IButtonCommand {
    
    private DeckCell deckCell;
    
    public SelectDeckCommand(DeckCell deckCell){
        this.deckCell = deckCell;
    }

    @Override
    public void execute() {
        Match.selectedDeck = deckCell.getItem();
    }
    
}
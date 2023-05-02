package controller.command.deckmanagement;

import controller.command.IButtonCommand;
import controller.fxml.Match;
import model.deckmanagement.DeckCell;

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
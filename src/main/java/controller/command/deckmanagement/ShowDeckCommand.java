package controller.command.deckmanagement;

import controller.command.IButtonCommand;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Card;
import model.Deck;
import model.deckmanagement.DeckCell;
/**
 * Class responsible for showing the Deck cards in the center listView
 *
 * @author massimilianobattelli
 */
public class ShowDeckCommand implements IButtonCommand {

    private ListView<Card> centerList;
    private Deck deck;
    private TextField deckNameTextField;
    private DeckCell deckCell;
    
    public ShowDeckCommand(DeckCell deckCell, ListView<Card> centerList, TextField deckNameTextField){
        this.deckCell = deckCell;
        this.centerList = centerList;
        this.deckNameTextField = deckNameTextField;
    }

    @Override
    public void execute() {
        this.deck = deckCell.getItem();
        if (!this.centerList.getItems().isEmpty()){
            this.centerList.getItems().clear();
        }
        this.deckNameTextField.setText(this.deck.getName());
        this.centerList.getItems().addAll(this.deck.getCards()); 
    }
}

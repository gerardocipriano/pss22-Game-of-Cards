package controller.command.deckmanagement;

import controller.command.IButtonCommand;
import javafx.scene.control.ListView;
import model.Card;
import model.deckmanagement.RightListCell;
/**
 * Class responsible for adding a Card to the listView on the screen center
 *
 * @author massimilianobattelli
 */
public class AddCard implements IButtonCommand{

    private ListView<Card> centerList;
    private Card card;

    public AddCard(RightListCell rightListCell, ListView<Card> centerList) {
        this.centerList = centerList;
    }

    @Override
    public void execute() {
        centerList.getItems().add(card);
    }

    public void setCard(Card card){
    this.card = card;
    }
}
package controller.command.deckmanagement;


import controller.command.IButtonCommand;
import javafx.scene.control.ListView;
import model.Card;
import model.deckmanagement.CenterListCell;
/**
 * Class responsible for removing a Card from the listView of the screen center
 *
 * @author massimilianobattelli
 */
public class RemoveCard implements IButtonCommand {
    private ListView<Card> centerList;
    private Card card;

    public RemoveCard(CenterListCell centerListCell, ListView<Card> centerList) {
        this.centerList = centerList;
    }

    @Override
    public void execute() {
        centerList.getItems().remove(card);
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

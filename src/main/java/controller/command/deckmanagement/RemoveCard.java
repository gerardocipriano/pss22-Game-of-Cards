package controller.command.deckmanagement;


import controller.command.IButtonCommand;
import javafx.scene.control.ListView;
import model.Card;
import model.deckmanagement.CenterListCell;

public class RemoveCard implements IButtonCommand {
    private ListView<Card> centerList;
    private Card card;

    public RemoveCard(CenterListCell centerListCell, ListView<Card> centerList, Card card) {
        this.centerList = centerList;
        this.card = card;
    }

    @Override
    public void execute() {
        centerList.getItems().remove(card);
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

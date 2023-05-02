package controller.command.deckmanagement;

import controller.command.IButtonCommand;
import javafx.scene.control.ListView;
import model.Card;
import model.deckmanagement.RightListCell;

public class AddCard implements IButtonCommand{

    private ListView<Card> centerList;
    private Card card;

    public AddCard(RightListCell rightListCell, ListView<Card> centerList, Card card) {
        this.centerList = centerList;
        this.card = card;
    }

    @Override
    public void execute() {
        centerList.getItems().add(card);
    }

    public void setCard(Card card){
    this.card = card;
    }
}
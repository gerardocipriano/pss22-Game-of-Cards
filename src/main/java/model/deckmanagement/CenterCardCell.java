package model.deckmanagement;

import javafx.scene.control.ListView;
import model.Card;
/*
 * This class represents the cells in the list on the center of the page
 */
public class CenterCardCell extends CardCell {

    
    public CenterCardCell(String buttonText, ListView<Card> centerList) {
        super(buttonText, centerList);
    }

    @Override
    protected void handleCards(Card card, ListView<Card> centerList) {
        if (card.isMoved()) {
                centerList.getItems().remove(card);
                card.setMoved(! card.isMoved());
            } 

        }   
}


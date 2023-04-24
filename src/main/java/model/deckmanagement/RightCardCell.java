package model.deckmanagement;

import javafx.scene.control.ListView;
import model.Card;
/*
 * This class represents the cells in the list on the right side
 */
public class RightCardCell extends CardCell {

    
    public RightCardCell(String buttonText, ListView<Card> centerList) {
        super(buttonText, centerList);
    }
    
    @Override
    protected void handleCards(Card card, ListView<Card> centerList) {
        if (!card.isMoved()) {
                centerList.getItems().add(card);
                card.setMoved(! card.isMoved());
            } 

        }
        
}


package model.deckmanagement;

import javafx.scene.control.ListView;
/*
 * This class represents the cells in the list on the center of the page
 */
public class CenterCell extends Cell {

    
    public CenterCell(String buttonText, ListView<DeckCard> centerList) {
        super(buttonText, centerList);
    }

    @Override
    protected void handleCards(DeckCard card, ListView<DeckCard> centerList) {
        if (card.isMoved()) {
                centerList.getItems().remove(card);
                card.setMoved(! card.isMoved());
            } 

        }   
}


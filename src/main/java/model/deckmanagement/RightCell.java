package model.deckmanagement;

import javafx.scene.control.ListView;

public class RightCell extends Cell {

    
    public RightCell(String buttonText, ListView<DeckCard> centerList) {
        super(buttonText, centerList);
    }

    @Override
    protected void handleCards(DeckCard card, ListView<DeckCard> centerList) {
        if (!card.isMoved()) {
                centerList.getItems().add(card);
                card.setMoved(! card.isMoved());
            } 

        }
        
}


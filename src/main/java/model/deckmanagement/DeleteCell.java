package model.deckmanagement;

import javafx.scene.control.ListView;

public class DeleteCell extends DeckCell {

    
    public DeleteCell(String buttonText, ListView<DeckCard> centerList) {
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


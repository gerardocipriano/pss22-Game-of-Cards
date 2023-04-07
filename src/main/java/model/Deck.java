package model;

import java.util.ArrayList;
import java.util.List;
import model.deckmanagement.DeckCard;

public class Deck {
    
    private List<DeckCard> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(DeckCard Card){
        this.cards.add(Card);
    }
    public String toString() {
        return "<Nome del deck>";
    }
}

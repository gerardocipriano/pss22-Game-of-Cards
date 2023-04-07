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

    public void getCards(){
        for ( DeckCard i : cards){
            System.out.println(i.toString());
        }
    }
}

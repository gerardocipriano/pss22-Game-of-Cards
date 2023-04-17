package model;

import java.util.ArrayList;
import java.util.List;
import model.deckmanagement.DeckCard;

public class Deck
        implements IDeck {
            
    private String name = "Name";
    private List<DeckCard> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addCard(DeckCard Card) {
        this.cards.add(Card);
    }

    public void printCards() {
        for (DeckCard i : this.cards) {
            System.out.println(i.toString());
        }
    }

    public Object getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}

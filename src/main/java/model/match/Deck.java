package model.match;

import java.util.ArrayList;
import java.util.List;
import model.deckmanagement.DeckCard;

public class Deck
        implements IDeck {

    private List<DeckCard> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(DeckCard Card) {
        this.cards.add(Card);
    }

    public String toString() {
        return "<Deck's Name>";
    }

    public void printCards() {
        for (DeckCard i : this.cards) {
            System.out.println(i.toString());
        }
    }
}

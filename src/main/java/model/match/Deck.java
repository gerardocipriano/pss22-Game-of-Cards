package model.match;

import java.util.ArrayList;
import java.util.List;

public class Deck
        implements IDeck {

    private List<ICard> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(ICard Card) {
        this.cards.add(Card);
    }

    public String toString() {
        return "<Deck's Name>";
    }

    public void printCards() {
        for (ICard i : this.cards) {
            System.out.println(i.toString());
        }
    }
}

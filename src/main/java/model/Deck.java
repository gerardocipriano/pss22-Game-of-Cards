package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that represents the deck
 *
 * @author massimilianobattelli
 */
public class Deck
        implements IDeck {
    
    private String name = "Name";
    private String image = "/images/img-deck.png";
    private List<Card> cards;
    

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addCard(Card Card) {
        this.cards.add(Card);
    }

    public void printCards() {
        for (Card i : this.cards) {
            System.out.println(i.toString());
        }
    }

    public List<Card> getCards(){
        return this.cards;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }
}

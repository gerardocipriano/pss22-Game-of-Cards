package model.match;

import model.deckmanagement.DeckCard;

public interface IDeck {

    public void addCard(DeckCard Card);

    public String toString();

    public void printCards();

}

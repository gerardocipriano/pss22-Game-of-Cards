package model.match;

import model.deckmanagement.DeckCard;

public interface IDeck {

    public void addCard(ICard Card);

    public String toString();

    public void printCards();

}

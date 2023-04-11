package model.match;

import model.deckmanagement.DeckCard;

public interface IPlayer {
    int discard(DeckCard card);

    void position(DeckCard card, int position);
}

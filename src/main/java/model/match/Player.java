package model.match;

import model.deckmanagement.DeckCard;

public interface Player {

    int discard(DeckCard card);

    void position(DeckCard card, int position);
}

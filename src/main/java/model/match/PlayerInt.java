package model.match;

import model.deckmanagement.DeckCard;

public interface PlayerInt {

    int discard(DeckCard card);

    void position(DeckCard card, int position);
}

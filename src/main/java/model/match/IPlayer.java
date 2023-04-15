package model.match;

import model.Card;

public interface IPlayer {
    void discard(DeckCard card);

    void position(Card card, int position);
}

package model.match;

import model.Card;

public interface IPlayer {
    int discard(Card card);

    void position(Card card, int position);
}

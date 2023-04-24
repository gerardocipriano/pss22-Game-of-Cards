package model.match;

import model.Card;

public interface PlayerInt {

    int discard(Card card);

    void position(Card card, int position);
}

package model.match;

import model.Card;

public class Player implements IPlayer {
    int health;
    int maana;

    @Override
    public void discard(DeckCard card) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'discard'");

        // this.maana += (card.maana / 2);
    }

    @Override
    public void position(Card card, int position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'position'");

        // if (position == true) {

        // this.maana -= (card.maana / 2);
        // }
    }

}

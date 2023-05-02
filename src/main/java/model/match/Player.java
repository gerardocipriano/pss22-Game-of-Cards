package model.match;

public class Player implements IPlayer {
    int health;
    int maana;

    @Override
    public void discard(ICard card) {

        int cardMaana = card.getMaana();
        this.maana += (cardMaana / 2);
    }

    @Override
    public void position(ICard card, int position) {

        /*if (position == true) {
            int cardMaana = card.getMaana();
            this.maana -= (cardMaana / 2);
        }*/
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCards'");
    }

    @Override
    public void getCards(IDeck deck) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCards'");
    }

}

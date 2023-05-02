package model.match;

public interface IPlayer {
    void discard(ICard card);

    void position(ICard card, int position);

    void getCards(IDeck deck);
}

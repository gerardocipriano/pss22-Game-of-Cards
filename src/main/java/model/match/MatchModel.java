package model.match;

import model.Deck;
import model.IDeck;

public class MatchModel implements IMatchModel {
    private IBoard board;
    private IDeck deck;
    private IPlayer player1;
    private IPlayer player2;
    private static MatchModel instance;

    public static IMatchModel getInstance() {
        if (instance == null) {
            instance = new MatchModel();
        }
        return instance;
    }

    private IBoard createGameBoard() {
        return new Board();
    }

    private IPlayer createPlayer() {
        return new Player();
    }

    public void start(IDeck deck) {
        this.deck = deck;

        player1 = createPlayer();
        player2 = createPlayer();

        IPlayer currentPlayer = starterPlayer(player1, player2);

        currentPlayer.getCards(deck);

        board = createGameBoard(player1, player2);

    }

}

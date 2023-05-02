package model.match;

import java.util.Random;

import model.Deck;
import model.IDeck;

public class MatchModel implements IMatchModel {
    private IBoard board;
    private model.match.Deck deck;
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

    @Override
    public void start(model.match.IDeck deck) {

        this.deck = (model.match.Deck) deck;

        player1 = createPlayer();
        player2 = createPlayer();

        IPlayer currentPlayer = starterPlayer(player1, player2);

        currentPlayer.getCards(deck);

        // board = createGameBoard(player1, player2);

    }

    @Override
    public IPlayer starterPlayer(IPlayer player1, IPlayer player2) {

        Random rand = new Random();

        int randomNumber = (rand.nextInt(2) + 1);

        if (randomNumber == 1)
            return player1;
        else
            return player2;
    }

}

package model.match;

import model.*;

public interface IMatchModel {

    void start(IDeck deck);

    IPlayer starterPlayer(IPlayer player1, IPlayer player2);

}

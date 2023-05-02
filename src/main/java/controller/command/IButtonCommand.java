package controller.command;

import model.Card;

/**
* This interface represents a generic button command.
* The implementation of this interface should define the logic of the command that will be
* executed when the button is pressed.
*
* @author gerardocipriano
*/
public interface IButtonCommand {
    /**
    * Executes the command implemented by the implementation class.
    */
    void execute();
}
package model.deckmanagement;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.deckmanagement.AddCard;
import controller.command.sound.PlayClipCommand;
import javafx.scene.control.ListView;
import model.Card;
/**
 * Class that represents the cell of a Card located in the right listView
 *
 * @author massimilianobattelli
 */
public class RightListCell extends CardCell {

    private ListView<Card> centerList;

    public RightListCell(ListView<Card> centerList) {
        super(centerList);
        this.centerList = centerList;
        buttonCommands.add(new AddCard(this, this.centerList, card));
        buttonCommands.add(new PlayClipCommand());
        MacroCommand buttonMacro = new MacroCommand(buttonCommands);
        cellButton.setOnAction(event -> {
            Card card = getItem();
            for (IButtonCommand command : buttonCommands) {
                if (command instanceof AddCard) {
                    ((AddCard) command).setCard(card);
                }
            }
            buttonMacro.execute();
        });
    }
    
}

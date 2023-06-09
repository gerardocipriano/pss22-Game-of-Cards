package model.deckmanagement;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.deckmanagement.RemoveCard;
import controller.command.sound.PlayClipCommand;
import javafx.scene.control.ListView;
import model.Card;
/**
 * Class that represents the cell of a Card located in the center listView
 *
 * @author massimilianobattelli
 */
public class CenterListCell extends CardCell {

    private ListView<Card> centerList;

    public CenterListCell(ListView<Card> centerList) {
        super(centerList);
        this.centerList = centerList;
        
        buttonCommands.add(new RemoveCard(this, this.centerList));
        buttonCommands.add(new PlayClipCommand());
        MacroCommand buttonMacro = new MacroCommand(buttonCommands);
        
        cellButton.setOnAction(event -> {
            Card card = getItem();
            for (IButtonCommand command : buttonCommands) {
                if (command instanceof RemoveCard) {
                    ((RemoveCard) command).setCard(card);
                }
            }
            buttonMacro.execute();
        });
    }  
}

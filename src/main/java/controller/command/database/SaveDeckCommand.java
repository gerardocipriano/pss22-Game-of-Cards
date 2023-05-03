package controller.command.database;

import java.util.ArrayList;
import java.util.List;

import controller.command.IButtonCommand;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import model.Card;
import model.Deck;
import utilities.InputValidator;
import utilities.parser.DeckParser;
/**
 * Class responsible for saving the deck in the json file
 *
 * @author massimilianobattelli
 */
public class SaveDeckCommand implements IButtonCommand {

    private ListView<Card> centerList;
    private ListView<Deck> leftList;
    private TextField deckNameTextField;
    private Button saveButton;

    public SaveDeckCommand(ListView<Deck> leftList, ListView<Card> centerList, TextField deckNameTextField, Button saveButton) {
        this.centerList = centerList;
        this.deckNameTextField = deckNameTextField;
        this.saveButton = saveButton;
        this.leftList = leftList;
    }
    /**
     * Instruction to save the deck, it uses {@link utilities.InputValidator} to validate the deck name
     * and {@link utilities.parser.DeckParser} to retrieve the decks and save it in the json
     */
    @Override
    public void execute() {
        Window currentWindow = saveButton.getScene().getWindow();
        Deck deck = new Deck();
        List<Deck> jsonDecks = new ArrayList<Deck>();
        String deckName = deckNameTextField.getText();
        
        if(!leftList.getItems().isEmpty()){
            jsonDecks = DeckParser.parseDecks();
            for (Deck existingDeck : jsonDecks) {
                if (!InputValidator.validateDeckName(deckName, existingDeck.getName(), currentWindow)) {
                    return;
                }
            }
        }
        
        if (!centerList.getItems().isEmpty()){
            deck.setName(deckNameTextField.getText());
            for (Card card : centerList.getItems()){
                deck.addCard(card);
            }
            boolean deckFound = false;
            List<Deck> leftListItems = leftList.getItems();
            for (int i = 0; i < leftListItems.size(); i++) {
                Deck existingDeck = leftListItems.get(i);
                if (existingDeck.getName().equals(deck.getName())) {
                    leftListItems.set(i, deck);
                    deckFound = true;
                    break;
                }
            }
            if (!deckFound) {
                leftList.getItems().add(deck);
            }
            DeckParser.writeDecks(leftList.getItems());
        }
    }   
}

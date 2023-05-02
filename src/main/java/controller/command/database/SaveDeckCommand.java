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
    
    @Override
    public void execute() {
        Window currentWindow = saveButton.getScene().getWindow();
        Deck deck = new Deck();
        List<Deck> deckList, jsonDecks = new ArrayList<Deck>();
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
            leftList.getItems().add(deck);
            deckList = leftList.getItems();
            DeckParser.writeDecks(deckList);
        }
    }   
}

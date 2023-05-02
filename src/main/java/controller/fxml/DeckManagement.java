package controller.fxml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.database.SaveDeckCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.sound.PlayClipCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Window;
import model.Card;
import model.Deck;
import utilities.InputValidator;
import utilities.parser.CardParser;
import utilities.parser.DeckParser;
import model.deckmanagement.CellFactory;

public class DeckManagement {

    @FXML private Button backButton;
    @FXML private ListView<Card> rightList, centerList;
    @FXML private ListView<Deck> leftList;
    @FXML private TextField deckNameTextField;
    @FXML private Button saveButton;

    public void initialize() {
        List<Card> cards = CardParser.parseCards();
        List<Deck> decks = DeckParser.parseDecks();
        ToggleGroup group = new ToggleGroup();
        List<IButtonCommand> backCommands = new ArrayList<IButtonCommand>();
        List<IButtonCommand> saveCommands = new ArrayList<IButtonCommand>();
        CellFactory cellFactory = new CellFactory(group, leftList, centerList);
        
        leftList.setCellFactory(view -> cellFactory.createDeckCell());
        centerList.setCellFactory(view -> cellFactory.createCardCell());
        rightList.setCellFactory(view -> cellFactory.createCardCell());
        /* Add the data retrieved from json files to the appropriate listView,
         * if the files are empty an error is raised, which is why the if statement
         */
        if (cards != null) {
            rightList.getItems().addAll(cards);  
        } 
        if (decks != null) {
            leftList.getItems().addAll(decks);
        } 
        // Commands for the back-to-mainmenu button
        backCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
        backCommands.add(new PlayClipCommand());
        MacroCommand backMacro = new MacroCommand(backCommands);
        backButton.setOnAction(event -> {
            backMacro.execute();
        });
        // Commands for the save button
        saveCommands.add(new SaveDeckCommand(leftList, centerList, deckNameTextField, saveButton));
        saveCommands.add(new PlayClipCommand());
        MacroCommand saveMacro = new MacroCommand(saveCommands);
        saveButton.setOnAction(event -> {
            saveMacro.execute();
        });
    }  
}

/*  @FXML
    void saveDeck(final ActionEvent event) throws IOException{
        PlayClipCommand playSound = new PlayClipCommand();
        Window currentWindow = backButton.getScene().getWindow();
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
        playSound.execute();
    } */
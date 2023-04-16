package controller.fxml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.sound.PlayClipCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import model.Deck;
import model.deckmanagement.RightCell;
import utilities.parser.Parser;
import model.deckmanagement.DeckCard;
import model.deckmanagement.DeckCell;
import model.deckmanagement.CenterCell;

public class DeckManagement {
    
    @FXML private Button backButton;
    @FXML private ListView<DeckCard> rightList;
    @FXML private ListView<DeckCard> centerList;
    @FXML private ListView<Deck> leftList;
    @FXML
    void saveDeck(final ActionEvent event) throws IOException{
        PlayClipCommand playSound = new PlayClipCommand();
        Deck deck = new Deck();
        List<Deck> deckList = new ArrayList<>();

        if (!centerList.getItems().isEmpty()){
            for (DeckCard card : centerList.getItems()){
                deck.addCard(card);
            }
            leftList.getItems().add(deck);
            deckList = leftList.getItems();
            Parser.writeDecks(deckList);
        }
        playSound.execute();
    }

    public void initialize() {
        List<DeckCard> cards = Parser.parseCards();
        List<Deck> decks = Parser.parseDecks();
        ToggleGroup group = new ToggleGroup();
        List<IButtonCommand> backCommands = new ArrayList<>();

        // Setting up the custom 'ListCell' for the three listView
        rightList.setCellFactory(param -> new RightCell("Add", centerList));
        centerList.setCellFactory(param -> new CenterCell("Remove", centerList));
        leftList.setCellFactory(param -> new DeckCell(leftList, group));
        
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

    }  
}
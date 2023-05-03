package controller.fxml;

import java.util.ArrayList;
import java.util.List;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.database.SaveDeckCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.sound.PlayClipCommand;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Card;
import model.Deck;
import utilities.parser.CardParser;
import utilities.parser.DeckParser;
import model.deckmanagement.CellFactory;
/**
 * Class that represents the controller for the DeckManagement GUI
 *
 * @author massimilianobattelli
 */
public class DeckManagement {
    /**
     * 
     * The button to go back to the main menu
     */
    @FXML private Button backButton;
    /**
     * 
     * ListView where the cards will be showed
     */
    @FXML private ListView<Card> rightList, centerList;
    /**
     * 
     * ListView where the decks will be showed
     */
    @FXML private ListView<Deck> leftList;
    /**
     * 
     * TextField to name the deck
     */
    @FXML private TextField deckNameTextField;
    /**
     * 
     * The button to save the current cards choosend into a deck
     */
    @FXML private Button saveButton;
    /**
     * 
     * Initializes the GUI
     * The listViews's cells are generated with a Factory pattern
     * {@link utilities.parser.DeckParser} is used to retrieve the cards and decks from the jsons
     */
    public void initialize() {
        List<Card> cards = CardParser.parseCards();
        List<Deck> decks = DeckParser.parseDecks();
        ToggleGroup group = new ToggleGroup();
        List<IButtonCommand> backCommands = new ArrayList<IButtonCommand>();
        List<IButtonCommand> saveCommands = new ArrayList<IButtonCommand>();
        CellFactory cellFactory = new CellFactory(group, leftList, centerList, deckNameTextField);
        
        leftList.setCellFactory(view -> cellFactory.createDeckCell());
        centerList.setCellFactory(view -> cellFactory.createCenterListCell());
        rightList.setCellFactory(view -> cellFactory.createRightListCell());
        
        if (cards != null) {
            rightList.getItems().addAll(cards);  
        } 
        if (decks != null) {
            leftList.getItems().addAll(decks);
        } 
        
        backCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
        backCommands.add(new PlayClipCommand());
        MacroCommand backMacro = new MacroCommand(backCommands);
        backButton.setOnAction(event -> {
            backMacro.execute();
        });
        
        saveCommands.add(new SaveDeckCommand(leftList, centerList, deckNameTextField, saveButton));
        saveCommands.add(new PlayClipCommand());
        MacroCommand saveMacro = new MacroCommand(saveCommands);
        saveButton.setOnAction(event -> {
            saveMacro.execute();
        });
    }  
}

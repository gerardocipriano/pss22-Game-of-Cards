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
        CellFactory cellFactory = new CellFactory(group, leftList, centerList, deckNameTextField);
        
        leftList.setCellFactory(view -> cellFactory.createDeckCell());
        centerList.setCellFactory(view -> cellFactory.createCenterListCell());
        rightList.setCellFactory(view -> cellFactory.createRightListCell());
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

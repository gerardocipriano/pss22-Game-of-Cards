package model.deckmanagement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Card;
import model.Deck;

import java.util.ArrayList;
import java.util.List;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.deckmanagement.DeleteDeckCommand;
import controller.command.deckmanagement.SelectDeckCommand;
import controller.command.deckmanagement.ShowDeckCommand;
import controller.command.sound.PlayClipCommand;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 * Class that represents the cell of a Deck which will be showed in the left listView
 *
 * @author massimilianobattelli
 */
public class DeckCell extends ListCell<Deck> {
    private Label label;
    private HBox buttonContainer;
    private VBox container;
    private Button showButton, deleteButton;
    private RadioButton selectButton;
    private List<IButtonCommand> deleteCommands = new ArrayList<IButtonCommand>();
    private List<IButtonCommand> selectCommands = new ArrayList<IButtonCommand>();
    private List<IButtonCommand> showCommands = new ArrayList<IButtonCommand>();
    private ListView<Card> centerList;
    private TextField deckNameTextField;

    public DeckCell(ListView<Deck> leftList, ListView<Card> centerList, ToggleGroup group, TextField deckNameTextField) {
        this.centerList = centerList;
        this.deckNameTextField = deckNameTextField;
        label = new Label();
        showButton = new Button("Show");
        deleteButton = new Button("Delete");
        selectButton = new RadioButton("Select");
        selectButton.setToggleGroup(group);
        buttonContainer = new HBox(showButton, deleteButton);
        
        container = new VBox(label, buttonContainer, selectButton);
        container.setPrefHeight(120);
        container.setPrefWidth(152);
       
        showCommands.add(new ShowDeckCommand(this, this.centerList, this.deckNameTextField));
        showCommands.add(new PlayClipCommand());
        MacroCommand showMacro = new MacroCommand(showCommands);
        showButton.setOnAction(event -> {
            showMacro.execute();
        });

        deleteCommands.add(new DeleteDeckCommand(this, leftList));
        deleteCommands.add(new PlayClipCommand());
        MacroCommand deleteMacro = new MacroCommand(deleteCommands);
        deleteButton.setOnAction(event -> {
            deleteMacro.execute();
        });

        selectCommands.add(new SelectDeckCommand(this));
        selectCommands.add(new PlayClipCommand());
        MacroCommand selectMacro = new MacroCommand(selectCommands);
        selectButton.setOnAction(e -> {
            selectMacro.execute();
        });
    }  

    protected void updateItem(Deck deck, boolean empty) {
        super.updateItem(deck, empty);
        if (empty || deck == null) {
            setGraphic(null);
        } else {
            label.setText(deck.toString());
            setGraphic(container);
            container.setBackground(new Background(new BackgroundImage(
                new Image(deck.getImage(), 120, 90, false, true),
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1, 1, true, true, false, false))));
            setGraphic(container);
        }
    }
}

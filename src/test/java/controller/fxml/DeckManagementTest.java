package controller.fxml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.sound.PlayClipCommand;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import model.Card;
import model.Deck;
import utilities.parser.CardParser;
import utilities.parser.DeckParser;
import view.screen.WindowConfigurator;
import model.deckmanagement.CellFactory;
import utilities.InputValidator;
import static org.testfx.api.FxAssert.verifyThat;

public class DeckManagementTest extends ApplicationTest {
    private final WindowConfigurator windowConfigurator = new WindowConfigurator();
    private DeckManagement deckManagement;

    @Override
    public void start(Stage stage) throws IOException {
        // Load the "MainMenu" scene and get its controller
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/DeckManagementGui.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        windowConfigurator.configure(stage);

        // Set the scene and show the stage
        stage.setScene(scene);
        stage.show();

    }

    @Test
    public void testLists() {
        // Test if lists are initialized correctly
        assertTrue(((ListView<Card>) lookup("#rightList").query()).getItems().size() != 0);
        //assertTrue(((ListView<Deck>) lookup("#leftList").query()).getItems().size() == 0);
    }
    
    @Test
    public void testSaveDeck() throws IOException {
        // Test save deck with valid input
        int deckNumber = lookup("#leftList").queryListView().getItems().size();
        Node container = lookup("#rightList .cell").nth(0).query();
        Node button = from(container).lookup(".button").query();
        clickOn("#rightList").clickOn(button);
        clickOn("#deckNameTextField").write("TestDeck");
        clickOn("#saveButton");
        assertTrue(((ListView<Deck>) lookup("#leftList").query()).getItems().size() == deckNumber + 1);
        /* 
        Node deckContainer = lookup("#leftList .cell").nth(deckNumber).query();
        Node delete = from(deckContainer).lookup(".button").query();
        clickOn("#leftList").clickOn(delete);
        */
        /* 
        // Test save deck with invalid deck name
        clickOn("#deckNameTextField").write("TestDeck");
        clickOn("#rightList").clickOn(0);
        clickOn("#centerList").clickOn(0);
        Window currentWindow = ((Button) lookup("#backButton").query()).getScene().getWindow();
        InputValidator.validateDeckName("TestDeck", "TestDeck", currentWindow);
        assertTrue(((ListView<Deck>) lookup("#leftList").query()).getItems().size() == 0);

        // Test save deck with no cards selected
        clickOn("#deckNameTextField").write("TestDeck2");
        clickOn("#saveDeckButton");
        assertTrue(((ListView<Deck>) lookup("#leftList").query()).getItems().size() == 0);
        */
    }
    
    @Test
    public void testBackButton() {
        // Test back button
        clickOn("#backButton");
        FxAssert.verifyThat("#decksButton", LabeledMatchers.hasText("Decks"));
    }

    
}

package controller.fxml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import model.Card;
import model.Deck;
import view.screen.WindowConfigurator;

public class DeckManagementTest extends ApplicationTest {
    private final WindowConfigurator windowConfigurator = new WindowConfigurator();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/DeckManagementGui.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        windowConfigurator.configure(stage);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testCardsList() {
        assertTrue(((ListView<Card>) lookup("#rightList").query()).getItems().size() != 0);
    }
    
    @Test
    public void testSaveDeck() throws IOException {
        int deckNumber = lookup("#leftList").queryListView().getItems().size();
        Node container = lookup("#rightList .cell").nth(0).query();
        Node button = from(container).lookup(".button").query();
        Node deckCell = lookup("#leftList .cell").nth(deckNumber).query();
    
        clickOn("#rightList").clickOn(button);
        clickOn("#deckNameTextField").write("TestDeck");
        clickOn("#saveButton");
        assertTrue(((ListView<Deck>) lookup("#leftList").query()).getItems().size() == deckNumber + 1);
        Node delete = from(deckCell).lookup(".button").nth(1).query();
        clickOn("#leftList").clickOn(delete);
    }
    
    @Test
    public void testBackButton() {
        clickOn("#backButton");
        FxAssert.verifyThat("#decksButton", LabeledMatchers.hasText("Decks"));
    }
}

/* 
// Test save deck with invalid deck name
    clickOn("#rightList").clickOn(button);
    clickOn("#deckNameTextField").write("TestDeck");
    clickOn("#saveButton");
    clickOn("#deckNameTextField").write("TestDeck");
    clickOn("#saveButton");
    Window currentWindow = ((Button) lookup("#backButton").query()).getScene().getWindow();
    InputValidator.validateDeckName("TestDeck", "TestDeck", currentWindow);
    assertTrue(((ListView<Deck>) lookup("#leftList").query()).getItems().size() == 0);
// Test save deck with no cards selected
        clickOn("#deckNameTextField").write("TestDeck2");
        clickOn("#saveDeckButton");
        assertTrue(((ListView<Deck>) lookup("#leftList").query()).getItems().size() == deckNumber);
*/
package controller.fxml;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import java.lang.reflect.Field;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import view.screen.WindowConfigurator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

public class RulesTest extends ApplicationTest {

    private final WindowConfigurator windowConfigurator = new WindowConfigurator();

    /**
     * Set up the test environment by loading the "Rules" scene and getting its
     * controller.
     *
     * @param stage the primary stage for this test
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/RulesGui.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        windowConfigurator.configure(stage);

        // Set the scene and show the stage
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Tests the setupTabPane method.
     */
    @Test
    public void testSetupTabPane() {
        Rules rules = new Rules();
        TabPane tabPane = new TabPane();
        try {
            Field tabPaneField = Rules.class.getDeclaredField("tabPane");
            tabPaneField.setAccessible(true);
            tabPaneField.set(rules, tabPane);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        rules.setupTabPane();
        Properties properties = rules.loadProperties();
        assertEquals(properties.size(), rules.getTabPane().getTabs().size(),
                "Expected number of tabs to match number of properties");
        for (int i = 0; i < rules.getTabPane().getTabs().size(); i++) {
            Tab tab = rules.getTabPane().getTabs().get(i);
            String key = tab.getText();
            assertTrue(properties.containsKey(key), "Expected properties to contain key: " + key);
            Text text = (Text) ((AnchorPane) ((SplitPane) tab.getContent()).getItems().get(0)).getChildren().get(0);
            assertEquals(properties.getProperty(key), text.getText(), "Expected text to match property value");
        }
    }

    /**
     * Tests the loadProperties method.
     */
    @Test
    public void testLoadProperties() {
        // Create a new instance of the Rules class
        Rules rules = new Rules();

        // Call the loadProperties method
        Properties properties = rules.loadProperties();

        // Verify that the properties have been loaded correctly
        assertEquals("Card Creation is composed of the following phases...", properties.getProperty("CardCreation"));
        assertEquals("Deck Management is composed of the following phases...",
                properties.getProperty("DeckManagement"));
    }
}

package controller.fxml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.sound.PlayClipCommand;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;
import javafx.util.Duration;


/**
* Controller for the Rules scene.
*/
/**
 * This class is the controller for the Rules scene.
 * It manages the logic for displaying the rules of the game.
 *
 * @author gerardocipriano
 */
public class Rules {
    @FXML private Button backButton;
    @FXML private TabPane tabPane;
    @FXML private Text cardCreationText;
    @FXML private Text deckManagementText;

    /**
     * Initializes the controller.
     * Loads the properties from the file and sets up the TabPane and backButton.
     */
    public void initialize() {
        Properties properties = loadProperties();
        cardCreationText.setText(properties.getProperty("cardCreation"));
        deckManagementText.setText(properties.getProperty("deckManagement"));
        setupTabPane();
        backButton.setOnAction(event -> {
            List<IButtonCommand> backCommands = new ArrayList<>();
            backCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
            backCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(backCommands);
            decksMacro.execute();
        });
    }

    /**
     * Loads the properties from the file.
     *
     * @return The loaded properties.
     */
    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("/rules/rules.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Sets up the TabPane by setting the opacity of the tabs and adding a listener to the selectedItem property.
     */
    private void setupTabPane() {
        for (int i = 1; i < tabPane.getTabs().size(); i++) {
            Tab tab = tabPane.getTabs().get(i);
            tab.getContent().setOpacity(0);
        }
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) {
                FadeTransition fadeOut = new FadeTransition(Duration.millis(500), oldValue.getContent());
                fadeOut.setFromValue(1.0);
                fadeOut.setToValue(0.0);
                fadeOut.setOnFinished(event -> {
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newValue.getContent());
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();
                });
                fadeOut.play();
            } else {
                FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newValue.getContent());
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            }
        });
    }
}
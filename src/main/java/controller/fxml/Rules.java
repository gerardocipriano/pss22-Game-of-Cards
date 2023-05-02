package controller.fxml;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.util.Duration;
import view.rules.TabPaneSetupView;
import view.rules.TabViewFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import controller.command.IButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.sound.PlayClipCommand;

/**
 * Controller for the rules scene.
 * Dynamically creates tabs based on entries in the properties file.
 *
 * @author gerardocipriano
 */
public class Rules {
    @FXML
    private Button backButton;
    @FXML
    private TabPane tabPane;

    /**
     * Initializes the controller.
     * Sets up the tab pane and the back button.
     */
    public void initialize() {
        TabPaneSetupView tabPaneSetup = new TabPaneSetupView("/rules/rules.properties");
        tabPaneSetup.setup(tabPane);
        backButton.setOnAction(event -> {
            List<IButtonCommand> backCommands = new ArrayList<>();
            backCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
            backCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(backCommands);
            decksMacro.execute();
        });
    }

    /**
     * Loads the properties from the properties file.
     *
     * @return the loaded properties
     */
    public Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("/rules/rules.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Returns the tabPane property.
     *
     * @return the tabPane property
     */
    public TabPane getTabPane() {
        return tabPane;
    }
}
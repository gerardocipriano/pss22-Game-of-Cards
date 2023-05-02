package controller.fxml;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.util.Duration;
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
     * Sets up the tab pane by creating tabs dynamically based on entries in the properties file.
     */
    void setupTabPane() {
        Properties properties = loadProperties();
        TabViewFactory tabViewFactory = new TabViewFactory(properties);
        for (String key : properties.stringPropertyNames()) {
            Tab tab = tabViewFactory.createTab(key);
            tabPane.getTabs().add(tab);
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

    /**
    * Returns the tabPane property.
    *
    * @return the tabPane property
    */
    public TabPane getTabPane() {
        return tabPane;
    }
}
package controller.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import view.rules.TabPaneSetupView;
import java.util.ArrayList;
import java.util.List;

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
     * Returns the tabPane property.
     *
     * @return the tabPane property
     */
    public TabPane getTabPane() {
        return tabPane;
    }
}
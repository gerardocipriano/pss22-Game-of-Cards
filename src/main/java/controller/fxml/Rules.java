package controller.fxml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import controller.command.ButtonCommand;
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
public class Rules  {
    
    @FXML
    private Button backButton;
    
    @FXML
    private TabPane tabPane;
    
    @FXML
    private Text cardCreationText;
    
    @FXML
    private Text deckManagementText;
    
    /**
    * 
    * Initializes the controller.
    * 
    */
    public void initialize() {
        //Get the text rules from the properties external file
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("/rules/rules.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Set content of labels according to the text in the rules.properties file
        cardCreationText.setText(properties.getProperty("cardCreation"));
        deckManagementText.setText(properties.getProperty("deckManagement"));
        
        // Set the opacity of the content of all tabs except the first one to 0 at startup
        for (int i = 1; i < tabPane.getTabs().size(); i++) {
            Tab tab = tabPane.getTabs().get(i);
            tab.getContent().setOpacity(0);
        }
        
        // Add a listener to the selected item property of the tab pane
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) {
                // Create and play a fade out transition for the content of the previous tab
                FadeTransition fadeOut = new FadeTransition(Duration.millis(500), oldValue.getContent());
                fadeOut.setFromValue(1.0);
                fadeOut.setToValue(0.0);
                fadeOut.setOnFinished(event -> {
                    // Create and play a fade in transition for the content of the new tab
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newValue.getContent());
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();
                });
                fadeOut.play();
            } else {
                // Create and play a fade in transition for the content of the first tab
                FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newValue.getContent());
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            }
        });

        backButton.setOnAction(event -> {
            List<ButtonCommand> backCommands = new ArrayList<>();
            backCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
            backCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(backCommands);
            decksMacro.execute();
        });
    }
}
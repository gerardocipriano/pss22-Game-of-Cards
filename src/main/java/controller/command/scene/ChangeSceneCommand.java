package controller.command.scene;

import java.io.IOException;

import controller.command.IButtonCommand;
import controller.fxml.SceneHandler;
import javafx.event.ActionEvent;

/**
 * ChangeSceneCommand class implements IButtonCommand interface to handle button click events and perform scene changes.
 *
 * @author gerardocipriano
 */
public class ChangeSceneCommand implements IButtonCommand {
    private String fxmlFile;
    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    /**
     * Constructor for ChangeSceneCommand.
     *
     * @param fxmlFile the name of the fxml file to open as a new scene
     */
    public ChangeSceneCommand(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    /**
     * Executes the command to open a new scene based on the provided fxml file name.
     * Handles IOException in case of failure to open the desired scene.
     */
    @Override
    public void execute() {
        try {
            switch (fxmlFile) {
                case "Settings.fxml":
                    sceneHandler.openSettings(new ActionEvent());
                    break;
                case "Rules.fxml":
                    sceneHandler.openRules(new ActionEvent());
                    break;
                case "Decks.fxml":
                    sceneHandler.openDeckManagement(new ActionEvent());
                    break;
                case "Match.fxml":
                    sceneHandler.openMatch(new ActionEvent());
                    break;
                case "MainMenu.fxml":
                    sceneHandler.openMainMenu(new ActionEvent());
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package controller.command.scene;

import java.io.IOException;

import controller.command.IButtonCommand;
import controller.scene.ISceneManagerController;
import controller.scene.SceneManagerSingleton;
import javafx.event.ActionEvent;

/**
 * ChangeSceneCommand class implements IButtonCommand interface to handle button click events and perform scene changes.
 *
 * @author gerardocipriano
 */
public class ChangeSceneCommand implements IButtonCommand {
    private String fxmlFile;
    private final ISceneManagerController sceneManager = SceneManagerSingleton.getInstance();

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
                    sceneManager.openSettings(new ActionEvent());
                    break;
                case "Rules.fxml":
                    sceneManager.openRules(new ActionEvent());
                    break;
                case "Decks.fxml":
                    sceneManager.openDeckManagement(new ActionEvent());
                    break;
                case "Match.fxml":
                    sceneManager.openMatch(new ActionEvent());
                    break;
                case "MainMenu.fxml":
                    sceneManager.openMainMenu(new ActionEvent());
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
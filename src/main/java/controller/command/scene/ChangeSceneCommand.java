package controller.command.scene;

import java.io.IOException;

import controller.command.ButtonCommand;
import controller.fxml.SceneHandler;
import javafx.event.ActionEvent;

public class ChangeSceneCommand implements ButtonCommand {
    private String fxmlFile;
    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    public ChangeSceneCommand(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

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
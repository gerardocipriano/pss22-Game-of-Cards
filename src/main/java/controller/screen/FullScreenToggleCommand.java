package controller.screen;

import javafx.stage.Stage;

public class FullScreenToggleCommand {
    private Stage stage;
    private boolean isFullScreen = false;

    public FullScreenToggleCommand(Stage stage) {
        this.stage = stage;
    }

    public void execute() {
        isFullScreen = !isFullScreen;
        stage.setFullScreen(isFullScreen);
    }
}
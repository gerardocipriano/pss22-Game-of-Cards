package controller.screen;

import javafx.stage.Stage;

public interface IFullScreenManagerController {

    void toggleFullScreen();
    boolean  isFullScreen();
    void setPrimaryStage(Stage stage);
}

package controller.screen;

import javafx.stage.Stage;

public interface IFullScreenController {

    void toggleFullScreen();
    boolean  isFullScreen();
    void setPrimaryStage(Stage stage);
}

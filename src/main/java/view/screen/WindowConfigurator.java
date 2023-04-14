package view.screen;

import controller.fxml.SceneHandler;
import controller.screen.FullScreenManagerSingleton;
import controller.screen.IFullScreenManagerController;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
* This class is responsible for configuring the window.
* @author gerardocipriano
*/
public class WindowConfigurator {

   private static final int SCENE_WIDTH = 1280;
   private static final int SCENE_HEIGHT = 720;
   private IFullScreenManagerController fullScreenManager = FullScreenManagerSingleton.getInstance();

   /**
    * Configures the given stage.
    * @param stage the stage to configure
    */
   public void configure(Stage stage) {
       SceneHandler.getInstance().setPrimaryStage(stage);
       fullScreenManager.setPrimaryStage(stage);

       stage.getIcons().add(new Image("/images/logo.png"));
       stage.setTitle("Game of Cards");
       stage.setResizable(true);
       stage.setWidth(SCENE_WIDTH);
       stage.setHeight(SCENE_HEIGHT);
       stage.setAlwaysOnTop(true);
       stage.setResizable(false);
   }
}

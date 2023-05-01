package view.screen;

import controller.scene.ISceneController;
import controller.scene.SceneControllerSingleton;
import controller.screen.FullScreenManagerSingleton;
import controller.screen.IFullScreenManagerController;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This class is responsible for configuring the window.
 * 
 * @author gerardocipriano
 */
public class WindowConfigurator {

    private static final int SCENE_WIDTH = 1280;
    private static final int SCENE_HEIGHT = 720;
    private final IFullScreenManagerController fullScreenManager = FullScreenManagerSingleton.getInstance();
    private final ISceneController sceneManager = SceneControllerSingleton.getInstance();
    private StageSizeTracker stageSizeTracker;

    /**
     * Configures the given stage.
     * 
     * @param stage the stage to configure
     */
    public void configure(Stage stage) {
        sceneManager.setPrimaryStage(stage);
        fullScreenManager.setPrimaryStage(stage);
        stageSizeTracker = new StageSizeTracker(stage);

        stage.getIcons().add(new Image("/images/logo.png"));
        stage.setTitle("Game of Cards");
        stage.setResizable(true);
        stage.setWidth(SCENE_WIDTH);
        stage.setHeight(SCENE_HEIGHT);
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
    }
}

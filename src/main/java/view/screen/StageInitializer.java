package view.screen;

import controller.scene.ISceneController;
import controller.scene.SceneControllerSingleton;
import controller.screen.FullScreenSingleton;
import controller.screen.IFullScreenController;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This class is responsible for configuring the window.
 * 
 * @author gerardocipriano
 */
public class StageInitializer {

    private static final int SCENE_WIDTH = 1280;
    private static final int SCENE_HEIGHT = 720;
    private final IFullScreenController fullScreenManager = FullScreenSingleton.getInstance();
    private final ISceneController sceneManager = SceneControllerSingleton.getInstance();
    @SuppressWarnings("unused")
    private StageSizeTracker stageSizeTracker;

    /**
     * Configures the given stage for the application.
     * e
     * 
     * @param stage the stage to configure
     */
    public void configureStage(Stage stage) {
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

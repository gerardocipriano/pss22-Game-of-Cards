package view.screen;


import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class StageSizeTracker {
    private static double stageWidth;
    private static double stageHeight;

    public StageSizeTracker(Stage stage) {
        stageWidth = stage.getWidth();
        stageHeight = stage.getHeight();

        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                stageWidth = (double) newSceneWidth;
            }
        });

        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                stageHeight = (double) newSceneHeight;
            }
        });
    }

    public static double getStageWidth() {
        return stageWidth;
    }

    public static double getStageHeight() {
        return stageHeight;
    }
}

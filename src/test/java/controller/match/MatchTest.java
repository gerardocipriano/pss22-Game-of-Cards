// package controller.match;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotEquals;

// import java.io.IOException;

// import org.junit.jupiter.api.Test;
// import org.testfx.api.FxAssert;
// import org.testfx.framework.junit5.ApplicationTest;
// import org.testfx.matcher.control.LabeledMatchers;

// import controller.sound.BackgroundMusic;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;
// import model.match.MatchModel;

// /**
//  * Test class for the Settings controller.
//  */
// public class MatchTest extends ApplicationTest {
//     private MatchModel matchController;

//     /**
//      * Set up the test environment by loading the "Settings" scene and getting its
//      * controller.
//      *
//      * @param stage the primary stage for this test
//      */
//     @Override
//     public void start(Stage stage) throws IOException {
//         // Load the "Settings" scene and get its controller
//         FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/SettingsGui.fxml"));
//         Parent root = loader.load();
//         matchController = loader.getController();

//         BackgroundMusic.getInstance().playMainTheme();
//         BackgroundMusic.getInstance().setVolume(0.5);

//         // Set the scene and show the stage
//         Scene scene = new Scene(root);
//         stage.setScene(scene);
//         stage.setAlwaysOnTop(true);
//         stage.show();
//     }

// }

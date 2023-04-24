package controller.fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import view.screen.WindowConfigurator;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;
import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import controller.sound.BackgroundMusicSingleton;
import controller.sound.IBackgroundMusicController;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class RulesTest extends ApplicationTest{
    
    private final WindowConfigurator windowConfigurator = new WindowConfigurator();
    /**
    * Set up the test environment by loading the "Rules" scene and getting its controller.
    *
    * @param stage the primary stage for this test
    */
    @Override
    public void start(Stage stage) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/RulesGui.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        windowConfigurator.configure(stage);
        
        // Set the scene and show the stage
        stage.setScene(scene);
        stage.show();
        
        IBackgroundMusicController bgMusic = BackgroundMusicSingleton.getInstance();
        bgMusic.play("main");
        bgMusic.setVolume(0.5);
    }
    /**
    * Tests the setupTabPane method.
    */
    @Test
    public void testSetupTabPane() {
        // Create a new instance of the Rules class
        Rules rules = new Rules();
        
        // Set up the tabPane with some test data
        TabPane tabPane = new TabPane();
        for (int i = 0; i < 3; i++) {
            Tab tab = new Tab();
            tab.setContent(new Text("Tab " + i));
            tabPane.getTabs().add(tab);
        }
        
        // Use reflection to set the value of the private tabPane field
        try {
            Field tabPaneField = Rules.class.getDeclaredField("tabPane");
            tabPaneField.setAccessible(true);
            tabPaneField.set(rules, tabPane);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
        // Call the setupTabPane method
        rules.setupTabPane();
        
        // Verify that the tabs have been set up correctly
        for (int i = 1; i < rules.getTabPane().getTabs().size(); i++) {
            Tab tab = rules.getTabPane().getTabs().get(i);
            assertEquals(0, tab.getContent().getOpacity(), 0.001, "Expected tab content opacity to be 0");
        }
    }

    
}

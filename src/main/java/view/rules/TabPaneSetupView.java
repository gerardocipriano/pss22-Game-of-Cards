package view.rules;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.animation.FadeTransition;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.util.Duration;

/**
 * This class is responsible for dynamically creating tabs and applying
 * animations to them
 * based on the entries present in the rules.properties file.
 * <p>
 * The {@code setup} method takes a {@code TabPane} as a parameter and
 * configures it by
 * creating tabs and adding them to the {@code TabPane}. The tabs are created
 * based on the
 * entries present in the rules.properties file. Animations are also applied to
 * the tabs
 * when they are selected.
 *
 * @author gerardocipriano
 */
public class TabPaneSetupView {
    private Properties properties;

    public TabPaneSetupView(String propertiesPath) {
        this.properties = loadProperties(propertiesPath);
    }

    public Properties loadProperties(String propertiesPath) {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream(propertiesPath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void setup(TabPane tabPane) {
        TabViewFactory tabViewFactory = new TabViewFactory(properties);
        for (String key : properties.stringPropertyNames()) {
            Tab tab = tabViewFactory.createTab(key);
            tabPane.getTabs().add(tab);
        }
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) {
                FadeTransition fadeOut = new FadeTransition(Duration.millis(500), oldValue.getContent());
                fadeOut.setFromValue(1.0);
                fadeOut.setToValue(0.0);
                fadeOut.setOnFinished(event -> {
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newValue.getContent());
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();
                });
                fadeOut.play();
            } else {
                FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newValue.getContent());
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            }
        });
    }
}
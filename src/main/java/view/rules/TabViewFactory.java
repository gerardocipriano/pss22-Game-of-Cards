package view.rules;

import java.util.Properties;

import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * Factory for creating tab views dynamically based on entries in the properties file.
 *
 * @author gerardocipriano
 */
public class TabViewFactory {
    private Properties properties;

    /**
     * Constructs a new TabViewFactory with the given properties.
     *
     * @param properties the properties to use for creating the tab views
     */
    public TabViewFactory(Properties properties) {
        this.properties = properties;
    }

    /**
     * Creates a new tab with the given key.
     *
     * @param key the key to use for creating the tab
     * @return the created tab
     */
    public Tab createTab(String key) {
        Tab tab = new Tab(key);
        SplitPane splitPane = new SplitPane();
        AnchorPane anchorPane1 = new AnchorPane();
        Text text = new Text(properties.getProperty(key));
        text.setLayoutX(14.0);
        text.setLayoutY(44.0);
        text.setWrappingWidth(600.0);
        anchorPane1.getChildren().add(text);
        AnchorPane anchorPane2 = new AnchorPane();
        ImageView imageView = new ImageView();
        imageView.setFitHeight(450.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        try {
            Image image = new Image("/images/" + key + ".jpg");
            imageView.setImage(image);
        } catch (Exception e) {
            // Image not found, use default image
            Image image = new Image("/images/img-not-found.jpg");
            imageView.setImage(image);
        }
        anchorPane2.getChildren().add(imageView);
        splitPane.getItems().addAll(anchorPane1, anchorPane2);
        tab.setContent(splitPane);
        return tab;
    }
}

package controller.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Card;

public class DeckManagement implements Initializable {
    private final SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private Button backButton;

    @FXML
    void backToMainMenu(final ActionEvent event) throws IOException {
        if (sceneHandler.getPrimaryStage() == null) {
            sceneHandler.setPrimaryStage((Stage) backButton.getScene().getWindow());
        }
        sceneHandler.openMainMenu(event);
    }
    
    @FXML
    private ListView<Card> rightList;

    @FXML
    private ListView<Card> centerList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rightList.setCellFactory(param -> new ListCell<Card>() {
            @Override
            protected void updateItem(Card card, boolean empty) {
                super.updateItem(card, empty);
                if (empty || card == null) {
                    setText(null);
                } else {
                    VBox container = new VBox();
                    Button cardButton = new Button("Add");
                    cardButton.setOnAction(event -> {
                        if (!card.isMoved()) {
                            centerList.getItems().add(card);
                            rightList.getItems().remove(card);
                            card.setMoved(true);
                        }
                    });
                    container.getChildren().addAll(new javafx.scene.control.Label(card.toString()), cardButton);
                    setGraphic(container);
                }
            }
        });
        rightList.getItems().addAll(
            new Card("Card 1", 10),
            new Card("Card 2", 5),
            new Card("Card 3", 8)
        );
       
    }
    
}

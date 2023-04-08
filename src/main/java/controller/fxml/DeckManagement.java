package controller.fxml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Deck;
import model.deckmanagement.RightCell;
import model.deckmanagement.DeckCard;
import model.deckmanagement.DeckCell;
import model.deckmanagement.CenterCell;

public class DeckManagement implements Initializable {
    private final SceneHandler sceneHandler = SceneHandler.getInstance();
    
    @FXML
    private Button backButton;

    @FXML
    private ListView<DeckCard> rightList;

    @FXML
    private ListView<DeckCard> centerList;

    @FXML
    private ListView<Deck> leftList;

    @FXML
        void backToMainMenu(final ActionEvent event) throws IOException {
            if (sceneHandler.getPrimaryStage() == null) {
                sceneHandler.setPrimaryStage((Stage) backButton.getScene().getWindow());
            }
            sceneHandler.openMainMenu(event);
        }
    
    @FXML
        void saveDeck(final ActionEvent event) throws IOException{
            Deck deck = new Deck();
            for (DeckCard card : centerList.getItems()){
                deck.addCard(card);
            }
            leftList.getItems().add(deck);
        }
        
    @Override
        public void initialize(URL location, ResourceBundle resources) {
            ToggleGroup group = new ToggleGroup();
            Gson gson = new Gson();
            List<DeckCard> cards = new ArrayList<>();
            String json = null;
            
            rightList.setCellFactory(param -> new RightCell("Add", centerList));
            centerList.setCellFactory(param -> new CenterCell("Remove", centerList));
            leftList.setCellFactory(param -> new DeckCell(leftList, group));

            // Leggo il json file come stringa
            try (FileReader reader = new FileReader("./src/main/resources/cards/cards.json")) {
                json = new BufferedReader(reader).lines().collect(Collectors.joining());
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Converto il json in una lista di carte
            cards = gson.fromJson(json, new TypeToken<List<DeckCard>>() {}.getType());
            //Aggiungo alla lista di destra le carte
            for (DeckCard card : cards) {
                rightList.getItems().addAll(card);
            }
            /* 
            Codice per salvare le carte nel json
            Gson gson = new Gson();
            String json = gson.toJson(card1);
            System.out.println(json);

            try (FileWriter writer = new FileWriter("./src/main/resources/cards/cards.json")) {
                writer.write(json);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
        }   
}
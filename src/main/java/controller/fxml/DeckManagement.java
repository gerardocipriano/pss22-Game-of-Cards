package controller.fxml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import controller.command.ButtonCommand;
import controller.command.MacroCommand;
import controller.command.scene.ChangeSceneCommand;
import controller.command.sound.PlayClipCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import model.Deck;
import model.deckmanagement.RightCell;
import model.deckmanagement.DeckCard;
import model.deckmanagement.DeckCell;
import model.deckmanagement.CenterCell;

public class DeckManagement {
    
    @FXML private Button backButton;
    @FXML private ListView<DeckCard> rightList;
    @FXML private ListView<DeckCard> centerList;
    @FXML private ListView<Deck> leftList;

    public void initialize() {
        List<DeckCard> cards = new ArrayList<>();
        String json = null;
        Gson gson = new Gson();
        ToggleGroup group = new ToggleGroup();

        //Render the data contained within each cell
        rightList.setCellFactory(param -> new RightCell("Add", centerList));
        centerList.setCellFactory(param -> new CenterCell("Remove", centerList));
        leftList.setCellFactory(param -> new DeckCell(leftList, group));

        //Read json file as string
        try (FileReader reader = new FileReader("./src/main/resources/cards/cards.json")) {
            json = new BufferedReader(reader).lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Convert json to card list and add them to the listView on the right
        cards = gson.fromJson(json, new TypeToken<List<DeckCard>>() {}.getType());
        for (DeckCard card : cards) {
            rightList.getItems().addAll(card);
        }

        backButton.setOnAction(event -> {
            List<ButtonCommand> backCommands = new ArrayList<>();
            backCommands.add(new ChangeSceneCommand("MainMenu.fxml"));
            backCommands.add(new PlayClipCommand());
            MacroCommand decksMacro = new MacroCommand(backCommands);
            decksMacro.execute();
        });

    }  

    @FXML
        void saveDeck(final ActionEvent event) throws IOException{
            PlayClipCommand playSound = new PlayClipCommand();
            playSound.execute();
            Deck deck = new Deck();
            for (DeckCard card : centerList.getItems()){
                deck.addCard(card);
            }
            leftList.getItems().add(deck);
        }
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
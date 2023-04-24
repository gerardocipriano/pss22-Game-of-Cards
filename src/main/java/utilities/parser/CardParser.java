package utilities.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Card;

public class CardParser {

    public static  List<Card> parseCards()  {
        List<Card> cards = new ArrayList<>();
        String json = null;
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("./src/main/resources/json/cards.json")) {
            json = new BufferedReader(reader).lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        cards = gson.fromJson(json, new TypeToken<List<Card>>() {});
        return cards;
    }

    public static void writeCards(List<Card> cards) {
        Gson gson = new Gson();
        String json = gson.toJson(cards);
        System.out.println(json);
    
        try (FileWriter writer = new FileWriter("./src/main/resources/json/cards.json")) {
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

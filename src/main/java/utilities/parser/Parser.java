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

import model.Deck;
import model.deckmanagement.DeckCard;
/* This class convert Java Objects into their JSON representation and vice-versa
 * using Gson library, in this case decks and cards
 */
public class Parser {

    public static List<DeckCard> parseCards()  {
        List<DeckCard> cards = new ArrayList<>();
        String json = null;
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("./src/main/resources/json/cards.json")) {
            json = new BufferedReader(reader).lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        cards = gson.fromJson(json, new TypeToken<List<DeckCard>>() {});
        return cards;
    }

    public static List<Deck> parseDecks(){
        List<Deck> decks = new ArrayList<>();
        String json = null;
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("./src/main/resources/json/decks.json")) {
            json = new BufferedReader(reader).lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        decks = gson.fromJson(json, new TypeToken<List<Deck>>() {});
        return decks;
    }

    public static void writeDecks(List<Deck> decks){
        Gson gson = new Gson();
        String json = gson.toJson(decks);
        System.out.println(json);
    
        try (FileWriter writer = new FileWriter("./src/main/resources/json/decks.json")) {
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCards(List<DeckCard> cards) {
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

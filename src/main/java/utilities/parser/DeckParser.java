package utilities.parser;

 

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Deck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeckParser {
    public static void writeDecks(List<Deck> decks) {
        Gson gson = new Gson();
        String json = gson.toJson(decks);
        System.out.println(json);
        try (OutputStream os = new FileOutputStream("./src/main/resources/json/decks.json");
             OutputStreamWriter writer = new OutputStreamWriter(os)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Deck> parseDecks() {
        List<Deck> decks = new ArrayList<>();
        String json = null;
        Gson gson = new Gson();
        try (InputStream is = DeckParser.class.getResourceAsStream("/json/decks.json");
             InputStreamReader reader = new InputStreamReader(is)) {
            json = new BufferedReader(reader).lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        decks = gson.fromJson(json, new TypeToken<List<Deck>>() {});
        return decks;
    }

 

    public static void deleteDeck(Deck deck) {
        String json = null;
        try (InputStream is = DeckParser.class.getResourceAsStream("/json/decks.json");
             InputStreamReader reader = new InputStreamReader(is)) {
            json = new BufferedReader(reader).lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        List<Deck> decks = new Gson().fromJson(json, new TypeToken<List<Deck>>() {});
        decks.removeIf(d -> d.getName().equals(deck.getName()));
        try (FileWriter writer = new FileWriter("./src/main/resources/json/decks.json")) {
            new Gson().toJson(decks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
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
/**
 * Class that has the task of reading and writing the decks in its own json file
 *
 * @author massimilianobattelli
 */
/*
public class DeckParser {

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

    public static void deleteDeck(Deck deck) {
        // Read the existing JSON data from the file into a string
        String json = null;

        try (FileReader reader = new FileReader("./src/main/resources/json/decks.json")) {
            json = new BufferedReader(reader).lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    
        // Parse the JSON data into a list of Deck objects
        List<Deck> decks = new Gson().fromJson(json, new TypeToken<List<Deck>>() {});
    
        // Find the deck to delete and remove it from the list
        decks.removeIf(d -> d.getName().equals(deck.getName()));
    
        // Write the updated list of decks back to the file
        try (FileWriter writer = new FileWriter("./src/main/resources/json/decks.json")) {
            new Gson().toJson(decks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
 */
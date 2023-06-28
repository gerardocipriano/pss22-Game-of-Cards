package utilities.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Deck;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeckParser {
    private static final String DECKS_FILE = "decks.json";

    public static void writeDecks(List<Deck> decks) {
        Gson gson = new Gson();
        String json = gson.toJson(decks);
        System.out.println(json);
        Path path = Paths.get(DECKS_FILE);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Deck> parseDecks() {
        List<Deck> decks = new ArrayList<>();
        String json = null;
        Gson gson = new Gson();
        Path path = Paths.get(DECKS_FILE);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            json = reader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        decks = gson.fromJson(json, new TypeToken<List<Deck>>() {
        });
        return decks;
    }

    public static void deleteDeck(Deck deck) {
        String json = null;
        Path path = Paths.get(DECKS_FILE);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            json = reader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        List<Deck> decks = new Gson().fromJson(json, new TypeToken<List<Deck>>() {
        });
        decks.removeIf(d -> d.getName().equals(deck.getName()));
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            new Gson().toJson(decks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

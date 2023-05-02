package utilities;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Modality;
import javafx.stage.Window;

public class InputValidator {

    private static final String[] ILLEGAL_CHARS = new String[] {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "=", "{", "}", "[", "]", "|", ";", ":", "'", "\"", ",", ".", "/", "<", ">", "?", "~"};
    
    public static Boolean validateDeckName(String deckName, String existingDeckName, Window window) {
        if (deckName.trim().isEmpty()) {
            showErrorDialog("Deck name cannot be empty", window);
            return false;
        }
        for (String s : ILLEGAL_CHARS) {
            if (deckName.contains(s)) {
                showErrorDialog("Deck name cannot contain illegal characters", window);
                return false;
            }
        }
        if (deckName.equals(existingDeckName)){
            Optional<ButtonType> result = showConfirmationDialog("Do you want to overwrite the existing deck?", window);
            if (result.isPresent() && result.get() == ButtonType.OK) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private static Optional<ButtonType> showConfirmationDialog(String message, Window window) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initOwner(window);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initModality(Modality.APPLICATION_MODAL);
        return alert.showAndWait();
    }

    private static void showErrorDialog(String message, Window window) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.initOwner(window);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.show();
    }
}

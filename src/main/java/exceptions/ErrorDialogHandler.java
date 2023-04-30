package exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * This class is responsible for showing error messages to the user using a dialog.
 * @author gerardocipriano
 */
public class ErrorDialogHandler {
    /**
     * Shows an error dialog to the user with the specified message.
     * @param message The message to show to the user.
     */
    public void showErrorDialog(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);
        stage.toFront();
        alert.showAndWait();
    }
}

package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import main.Note;

import java.util.*;

public class ControllerTap {
    Map<String, Boolean> buttonPressed = new HashMap<>();
    Map<String, ControllerSound.PlayNote> buttonThread = new HashMap<>();

    @FXML
    private Button A;

    @FXML
    private Button S;

    @FXML
    private Button D;

    @FXML
    private Button F;

    @FXML
    private Button G;

    @FXML
    private Button H;

    @FXML
    private Button J;

    @FXML
    private Button W;

    @FXML
    private Button E;

    @FXML
    private Button T;

    @FXML
    private Button Y;

    @FXML
    private Button U;

    private Button getButtonByName(String name) {
        switch (name) {
            case "A":
                return A;
            case "S":
                return S;
            case "D":
                return D;
            case "F":
                return F;
            case "G":
                return G;
            case "H":
                return H;
            case "J":
                return J;
            case "W":
                return W;
            case "E":
                return E;
            case "T":
                return T;
            case "Y":
                return Y;
            case "U":
                return U;
            default:
                throw new IllegalArgumentException();
        }
    }

    private ControllerSound controllerSound = new ControllerSound();

    private void onTap(Button button, String nameButton) {
        int noteCode = Note.getNoteByKey(nameButton).code;
        if (!buttonPressed.getOrDefault(nameButton, false)) {
            button.setStyle("-fx-border-color: black; -fx-background-color: orange");
            ControllerSound.PlayNote noteThread = controllerSound.playNote(noteCode);
            buttonThread.put(nameButton, noteThread);
            if (!buttonPressed.keySet().contains(nameButton))
                buttonPressed.put(nameButton, true);
            else
                buttonPressed.replace(nameButton, true);
        }
    }

    private void onRelease(Button button, String nameButton) {
        List<String> blackButton = Arrays.asList("W", "E", "T", "Y", "U");
        try {
            buttonThread.get(nameButton).setStop();
        } catch (NullPointerException e) {}
        if (blackButton.contains(nameButton))
            button.setStyle("-fx-border-color: black; -fx-background-color: black");
        else
            button.setStyle("-fx-border-color: black; -fx-background-color: white");
        if (!buttonPressed.keySet().contains(nameButton))
            buttonPressed.put(nameButton, false);
        else
            buttonPressed.replace(nameButton, false);
    }

    @FXML
    void keyTap(KeyEvent keyEvent) {
        if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
            try {
                String nameButton = keyEvent.getCode().getChar();
                Button button = getButtonByName(nameButton);
                onTap(button, nameButton);
            } catch (IllegalArgumentException e) {
                System.out.println("Not correct button: " + e.toString());
            }
        }
    }

    @FXML
    void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
            try {
                String nameButton = keyEvent.getCode().getChar();
                Button button = getButtonByName(nameButton);
                onRelease(button, nameButton);
            } catch (IllegalArgumentException e) {
                System.out.println("Not correct button: " + e.toString());
            }
        }
    }

    @FXML
    void mouseTap(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
            Button button = (Button) mouseEvent.getSource();
            onTap(button, button.getId());
        }
    }

    @FXML
    void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
            Button button = (Button) mouseEvent.getSource();
            String nameButton = button.getId();
            onRelease(button, nameButton);
        }
    }
}

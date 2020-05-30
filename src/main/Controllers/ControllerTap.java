package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.*;

public class ControllerTap {
    Map<String, Boolean> buttonPressed = new HashMap<>();

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

    @FXML
    void keyTap(KeyEvent keyEvent) {
        if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
            boolean isOk = true;
            Button button = (Button) keyEvent.getSource();
            String nameButton = keyEvent.getCode().getChar();
            switch (nameButton) {
                case "A":
                    button = A;
                    break;
                case "S":
                    button = S;
                    break;
                case "D":
                    button = D;
                    break;
                case "F":
                    button = F;
                    break;
                case "G":
                    button = G;
                    break;
                case "H":
                    button = H;
                    break;
                case "J":
                    button = J;
                    break;
                case "W":
                    button = W;
                    break;
                case "E":
                    button = E;
                    break;
                case "T":
                    button = T;
                    break;
                case "Y":
                    button = Y;
                    break;
                case "U":
                    button = U;
                    break;
                default:
                    isOk = false;
                    break;
            }
            if (isOk && !buttonPressed.getOrDefault(nameButton, false)) {
                button.setStyle("-fx-border-color: black; -fx-background-color: grey");
                ControllerSound.playSound(ControllerSound.getCode(keyEvent.getCode().toString()));
                if (!buttonPressed.keySet().contains(nameButton)) buttonPressed.put(nameButton, true);
                else buttonPressed.replace(nameButton, true);
            }
        }
    }

    @FXML
    void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
            Button button = (Button )keyEvent.getSource();
            String nameButton = keyEvent.getCode().getChar();
            boolean isOk = true;
            switch (nameButton) {
                case "A":
                    button = A;
                    break;
                case "S":
                    button = S;
                    break;
                case "D":
                    button = D;
                    break;
                case "F":
                    button = F;
                    break;
                case "G":
                    button = G;
                    break;
                case "H":
                    button = H;
                    break;
                case "J":
                    button = J;
                    break;
                case "W":
                    button = W;
                    break;
                case "E":
                    button = E;
                    break;
                case "T":
                    button = T;
                    break;
                case "Y":
                    button = Y;
                    break;
                case "U":
                    button = U;
                    break;
                default:
                    isOk = false;
                    break;
            }
            if (isOk && buttonPressed.getOrDefault(nameButton, true)) {
                List<String> blackButton = Arrays.asList("W", "E", "T", "Y", "U");
                if (blackButton.contains(nameButton))
                    button.setStyle("-fx-border-color: black; -fx-background-color: black");
                else
                    button.setStyle("-fx-border-color: black; -fx-background-color: white");
                if (!buttonPressed.keySet().contains(nameButton)) buttonPressed.put(nameButton, false);
                else buttonPressed.replace(nameButton, false);
            }
        }
    }

    @FXML
    void mouseTap(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
            Button button = (Button) mouseEvent.getSource();
            button.setStyle("-fx-border-color: black; -fx-background-color: grey");
            ControllerSound.playSound(ControllerSound.getCode(button.getId()));
        }
    }

    @FXML
    void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
            Button button = (Button) mouseEvent.getSource();
            button.setStyle("-fx-border-color: black; -fx-background-color: white");
        }
    }

    @FXML
    void mouseReleasedBlack(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
            Button button = (Button) mouseEvent.getSource();
            button.setStyle("-fx-border-color: black; -fx-background-color: black");
        }
    }
}

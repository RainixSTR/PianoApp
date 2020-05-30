module PianoApp {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;

    opens main;
    opens main.Controllers;
}
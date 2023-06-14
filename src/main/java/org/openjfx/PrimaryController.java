package org.openjfx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private Button primaryButton;

    @FXML
    private TextField username;

    @FXML
    void printUsername(ActionEvent event) {
        System.out.println(username.getText());
    }
}

package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    JFXTextField display;
    int n1, n2;
    int symbol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        n1 = n2 = 0;
        symbol = 0;
    }

    public void onDigPress(ActionEvent e) {
        String num = ((JFXButton) e.getSource()).getText();
        display.setText(display.getText() + num);
    }

    public void onAddPressed() {
        n1 = Integer.parseInt(display.getText());
        display.setText("");
        symbol = 1;
    }

    public void onSubPressed() {
        n1 = Integer.parseInt(display.getText());
        display.setText("");
        symbol = 2;
    }

    public void onMultPressed() {
        n1 = Integer.parseInt(display.getText());
        display.setText("");
        symbol = 3;
    }

    public void onDivPressed() {
        n1 = Integer.parseInt(display.getText());
        display.setText("");
        symbol = 4;
    }

    public void onClearPressed() {
        n1 = n2 = 0;
        display.setText("");
        symbol = 0;
    }

    public void onEqualsPressed() {
        n2 = Integer.parseInt(display.getText());
        if (symbol == 1) {
            display.setText(Integer.toString(n2 + n1));
        } else if (symbol == 2) {
            display.setText(Integer.toString(n1 - n2));
        } else if (symbol == 3) {
            display.setText(Integer.toString(n1 * n2));
        } else if (symbol == 4) {
            display.setText(Integer.toString(n1 / n2));
        }
    }
}
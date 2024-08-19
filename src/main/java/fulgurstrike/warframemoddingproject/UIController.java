package fulgurstrike.warframemoddingproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

public class UIController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private ListView<Integer> listView;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int[] randomArray = new int[200];
        int length = randomArray.length;
        Random rand = new Random();

        for (int i=0; i<length; i++) {
            randomArray[i] = rand.nextInt(1000);
            listView.getItems().add(randomArray[i]);
        }
    }
}
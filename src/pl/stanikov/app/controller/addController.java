package pl.stanikov.app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.stanikov.app.main.Cat;
import pl.stanikov.app.main.Dog;
//import pl.stanikov.app.main.Main;

public class addController implements Initializable{
	Cat kotek;
	Dog piesek;
	
    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private TextField petName;

    @FXML
    private TextField petRasa;

    @FXML
    private Label id;

    @FXML
    private Button backButton;

    @FXML
    private Button addButton;
    
    @FXML
    void add(ActionEvent event) {
    	kotek = new Cat("Mruczek", "Perski", 1);
    	kotek.addCat(kotek);
    }
    
    @FXML
    void back(ActionEvent event) {
    	kotek.getCats();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choice.getItems().addAll("Pies", "Kot");		
	}

}

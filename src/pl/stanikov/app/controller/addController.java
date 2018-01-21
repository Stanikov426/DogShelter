package pl.stanikov.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.stanikov.app.main.Cat;
import pl.stanikov.app.main.Dog;

public class addController implements Initializable{
	private Stage stage;
	Cat kotek;
	Dog piesek;
	private int counter=0;
	
    public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public void setIdText() {
		String strI = Integer.toString(getCounter());
		id.setText(strI);
	}

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
    	if(petRasa.getText().equals("")||petName.getText().equals("")) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Ups...");
    		alert.setHeaderText(null);
    		alert.setContentText("Uzupelnij dane :)");

    		alert.showAndWait();
    	}
    	else if(choice.getValue()=="Kot") {
    		kotek = new Cat(petName.getText(), petRasa.getText(), getCounter());
    		setCounter(getCounter()+1);
    		setIdText();
        	kotek.addCat(kotek);
    	}
    	else if(choice.getValue()=="Pies") {
    		piesek = new Dog(petName.getText(), petRasa.getText(), getCounter());
    		setCounter(getCounter()+1);
    		setIdText();
    		piesek.addDog(piesek);
    	}
    }
    
    @FXML
    void back(ActionEvent event) throws IOException {
    	stage = (Stage) addButton.getScene().getWindow();
        Parent root;
        root = (Parent) FXMLLoader.load(getClass().getResource("/pl/stanikov/app/view/MainPane.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
		stage.show();
        System.out.println("opened");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//setCounter(1);
		setIdText();

		choice.getItems().addAll("Pies", "Kot");
	}

}

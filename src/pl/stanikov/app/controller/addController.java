package pl.stanikov.app.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.stanikov.app.main.Main;


public class addController implements Initializable{
	private Stage stage;
	private int counter;
	Image image = null;
	LocalDate time;
	
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
    private Button addFotoButton;

    @FXML
    private ImageView myimageView;
    
    @FXML
    void add(ActionEvent event) {
    	if(petRasa.getText().equals("")||petName.getText().equals("")||image==null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Ups...");
    		alert.setHeaderText(null);
    		alert.setContentText("Uzupelnij dane :)");

    		alert.showAndWait();
    	}
    	if(Main.getCounter()==20) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Ups...");
    		alert.setHeaderText(null);
    		alert.setContentText("Brak miejsc :(");

    		alert.showAndWait();
    	}
    	else if(choice.getValue()=="Kot") {
    		time = LocalDate.now();
    		Main.addCat(petName.getText(), petRasa.getText(), getCounter(), image, time);    		
    		Main.setCounter(Main.getCounter()+1);
    		setCounter(Main.getCounter());
    		setIdText();
    	}
    	else if(choice.getValue()=="Pies") {
    		time = LocalDate.now();
    		Main.addDog(petName.getText(), petRasa.getText(), getCounter(), image, time);  		
    		Main.setCounter(Main.getCounter()+1);
    		setCounter(Main.getCounter());
    		setIdText();
    	}
    }
    
    @FXML
    void back(ActionEvent event) throws IOException {
    	stage = (Stage) backButton.getScene().getWindow();
        Parent root;
        root = (Parent) FXMLLoader.load(getClass().getResource("/pl/stanikov/app/view/MainPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
		stage.show();
        System.out.println("opened");
    }

    @FXML
    void addFoto(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
        
        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
          
        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
                   
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            image = SwingFXUtils.toFXImage(bufferedImage, null);
            myimageView.setImage(image);
        } catch (IOException ex) {
           // Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCounter(Main.getCounter());
		setIdText();

		choice.getItems().addAll("Pies", "Kot");
	}

}

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

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    

public class addController implements Initializable{
	private Stage stage;
	private int counter;
	Image image = null;
	File file;
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
    	if(Main.getCounter()==20) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Ups...");
    		alert.setHeaderText(null);
    		alert.setContentText("Brak miejsc :(");
    		
    		alert.showAndWait();
    		
    		send("dc.shelter0@gmail.com","123456ms","M.Staniszewski16@gmail.com","Schronisko","Próbowano dodaæ nowego zwierzaka ale nie ma ju¿ miejsc :/"); 
    	}
    	else if(petRasa.getText().equals("")||petName.getText().equals("")||image==null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Ups...");
    		alert.setHeaderText(null);
    		alert.setContentText("Uzupelnij dane :)");

    		alert.showAndWait();
    	}
    	else if(choice.getValue()=="Kot") {
    		time = LocalDate.now();
    		Main.addCat(petName.getText(), petRasa.getText(), getCounter(), image, time, file);    		
    		//Main.setCounter(Main.getCounter()+1);
    		setCounter(Main.getCounter());
    		setIdText();
    	}
    	else if(choice.getValue()=="Pies") {
    		time = LocalDate.now();
    		Main.addDog(petName.getText(), petRasa.getText(), getCounter(), image, time, file);  		
    		//Main.setCounter(Main.getCounter()+1);
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
        file = fileChooser.showOpenDialog(null);
                   
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            image = SwingFXUtils.toFXImage(bufferedImage, null);
            myimageView.setImage(image);
        } catch (IOException ex) {
            System.out.println("Zdjecie nie zostalo stworzone");
        }
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCounter(Main.getCounter());
		setIdText();

		choice.getItems().addAll("Pies", "Kot");
	}	
	
	public void send(String from,String password,String to,String sub,String msg){  
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);    
         //send message  
         Transport.send(message);    
         System.out.println("Wyslano maila...");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
           
  }  
}

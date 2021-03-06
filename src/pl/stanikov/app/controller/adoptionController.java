package pl.stanikov.app.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.stanikov.app.main.Cat;
import pl.stanikov.app.main.Dog;
import pl.stanikov.app.main.Main;

public class adoptionController implements Initializable {
	private Stage stage;

    @FXML
    private Label nameLabel;

    @FXML
    private Label rasaLabel;

    @FXML
    private ImageView imageView;
    
    @FXML
    void Click(ActionEvent event) {
    	stage = (Stage) nameLabel.getScene().getWindow();
    	if(Main.getPom()==true) {
			Dog test = Main.getPomDog();
			Main.adoptionDog(test);
			Main.setPomDog(null);
			stage.close();
		}
		else {
			Cat test = Main.getPomCat();
			Main.adoptionCat(test);
			Main.setPomCat(null);
			stage.close();
			
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(Main.getPom()==true) {
			Dog test = Main.getPomDog();
			nameLabel.setText(test.getPetName());
			rasaLabel.setText(test.getPetRasa());
			imageView.setImage(pathToImage(test.getFile()));
		}
		else {
			Cat test = Main.getPomCat();
			nameLabel.setText(test.getPetName());
			rasaLabel.setText(test.getPetRasa());
			imageView.setImage(pathToImage(test.getFile()));
		}
	}
	private Image pathToImage(File file) {
        
        try {
            BufferedImage bufferedImage = ImageIO.read(file);;
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            return image;
        } catch (IOException ex) {
            System.out.println("Zdjecie nie zostalo stworzone");
            return null;
        }
	}

}

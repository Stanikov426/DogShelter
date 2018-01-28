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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class aboutController implements Initializable {
	private Stage stage;

    @FXML
    private WebView webView;

    @FXML
    void backClick(ActionEvent event) throws IOException{
    	stage = (Stage) webView.getScene().getWindow();
        Parent root;
        root = (Parent) FXMLLoader.load(getClass().getResource("/pl/stanikov/app/view/MainPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
		stage.show();
        System.out.println("opened");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		WebEngine webEngine = webView.getEngine();
		webEngine.load("http://www.napaluchu.waw.pl");
	}

}


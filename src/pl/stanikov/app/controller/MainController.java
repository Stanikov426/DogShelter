package pl.stanikov.app.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController{
	private Stage stage;

    @FXML
    private Button addButton;

    @FXML
    private Button statusButton;

    @FXML
    private Button aboutButton;

    @FXML
    void aboutClick(ActionEvent event) throws IOException {
    	stage = (Stage) addButton.getScene().getWindow();
        Parent root;
        root = (Parent) FXMLLoader.load(getClass().getResource("/pl/stanikov/app/view/aboutPane.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
		stage.show();
        System.out.println("opened");
    }

    @FXML
    void addClick(ActionEvent event) throws IOException {
    	stage = (Stage) addButton.getScene().getWindow();
        Parent root;
        root = (Parent) FXMLLoader.load(getClass().getResource("/pl/stanikov/app/view/addPane.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
		stage.show();
        System.out.println("opened");
    }

    @FXML
    void statusClick(ActionEvent event) throws IOException {
    	stage = (Stage) addButton.getScene().getWindow();
        Parent root;
        root = (Parent) FXMLLoader.load(getClass().getResource("/pl/stanikov/app/view/statusPane.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
		stage.show();
        System.out.println("opened");
    }


}


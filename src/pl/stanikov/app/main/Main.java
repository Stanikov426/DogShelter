package pl.stanikov.app.main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	ArrayList<Cat> cats = new ArrayList<>();
	ArrayList<Dog> dogs = new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/pl/stanikov/app/view/MainPane.fxml"));
			Scene scene = new Scene(parent);
			primaryStage.setTitle("Schronisko");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);//Zakonczenie aplikacji
	}
	
	public void addCat(Cat cat) {
		cats.add(cat);
		System.out.println("Dodano kotka");
	}
	
	public void getCats() {
		for (Cat num : cats) {
            System.out.println(num);
        }
	}
	
}

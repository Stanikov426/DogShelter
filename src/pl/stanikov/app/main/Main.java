package pl.stanikov.app.main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	private int licznik;

	public int getLicznik() {
		return licznik;
	}

	public void setLicznik(int licznik) {
		this.licznik = licznik;
	}

	ArrayList<Cat> cats = new ArrayList<>();
	ArrayList<Dog> dogs = new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) {
		setLicznik(1);

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
	
	public void addDog(Dog dog) {
		dogs.add(dog);
		System.out.println("Dodano psa");
	}
	
	public void getDogs() {
		for (Dog num : dogs) {
            System.out.println(num);
        }
	}
}
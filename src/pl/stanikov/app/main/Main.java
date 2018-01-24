package pl.stanikov.app.main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {	

	static ArrayList<Cat> cats = new ArrayList<>();
	static ArrayList<Dog> dogs = new ArrayList<>();
	
	static Cat pomCat;
	static Dog pomDog;
	
	static Boolean pom;
	public static Boolean getPom() {
		return pom;
	}

	public static void setPom(Boolean pom) {
		Main.pom = pom;
	}

	public static Dog getPomDog() {
		return pomDog;
	}

	public static void setPomDog(Dog pomDog) {
		Main.pomDog = pomDog;
	}

	public static Cat getPomCat() {
		return pomCat;
	}

	public static void setPomCat(Cat pomCat) {
		Main.pomCat = pomCat;
	}
	static private int Counter = 0;
	
	public static int getCounter() {
		return Counter;
	}

	public static void setCounter(int counter) {
		Counter = counter;
	}

	public static void setCats(ArrayList<Cat> cats) {
		Main.cats = cats;
	}

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
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}
	
	public static void main(String[] args) {
		launch(args);//Zakonczenie aplikacji
	}
	
	public static void addCat(String name, String rasa, int id) {
		Cat cat = new Cat(name, rasa, id);
		cats.add(cat);
		System.out.println("Dodano kotka");
		System.out.println(cat.getId());
	}
	
	public static void addDog(String name, String rasa, int id) {
		Dog dog = new Dog(name, rasa, id);
		dogs.add(dog);
		System.out.println("Dodano psa");
		System.out.println(dog.getId());
	}
	
	public static ArrayList<Dog> getDogs() {
		return dogs;
	}
	public static ArrayList<Cat> getCats() {
		return cats;
	}
}
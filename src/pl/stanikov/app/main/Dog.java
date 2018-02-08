package pl.stanikov.app.main;

import java.io.File;
import java.time.LocalDate;

import javafx.scene.image.Image;

public class Dog extends Pet{
	
	public Dog(String name, String rasa, int id, Image image, LocalDate time, File file) {
		super(name, rasa, id, image, time, file);
	}
	public Dog() {}
	
	public void makeNoise() {
		System.out.println("Wof Wof!!!");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + " " + getPetName()+ " " + getPetRasa();
	}
	public String getType() {
		return "Dog";
	}
}

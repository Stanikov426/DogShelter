package pl.stanikov.app.main;

import java.time.LocalDate;

import javafx.scene.image.Image;

public class Dog extends Pet{
	
	public Dog(String name, String rasa, int id, Image image, LocalDate time) {
		super(name, rasa, id, image, time);
	}
	
	public void makeNoise() {
		System.out.println("Wof Wof!!!");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + " " + getPetName()+ " " + getPetRasa();
	}

}

package pl.stanikov.app.main;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.scene.image.Image;



public class Cat extends Pet implements Serializable{
	private static final long serialVersionUID = 3812017177088226528L;
	
	public Cat(String name, String rasa, int id, Image image, LocalDate time) {
		super(name, rasa, id, image, time);
	}
	public Cat() {
		
	}
	
	public void makeNoise() {
		System.out.println("Mial Mial!!!");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + " " + getPetName()+ " " + getPetRasa();
	}
}

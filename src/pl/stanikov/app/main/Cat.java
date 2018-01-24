package pl.stanikov.app.main;

import java.io.Serializable;



public class Cat extends Pet implements Serializable{
	private static final long serialVersionUID = 3812017177088226528L;
	
	public Cat(String name, String rasa, int id) {
		super(name, rasa, id);
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

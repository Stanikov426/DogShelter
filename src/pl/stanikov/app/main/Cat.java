package pl.stanikov.app.main;

public class Cat extends Pet{
	
	public Cat(String name, String rasa, int id) {
		super(name, rasa, id);
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

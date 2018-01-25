package pl.stanikov.app.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.image.Image;

public class Pet{
	private String petName;
	private String petRasa;
	private Image petImage;
	private LocalDate petDate;
	private int id;
	
	public String getPetTime() {
		DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String format = petDate.format(formatter_2);
		System.out.println(format);
		return format;
	}
	public void setPetTime(LocalDate petTime) {
		this.petDate = petTime;
	}
	
	public Image getPetImage() {
		return petImage;
	}
	public void setPetImage(Image petImage) {
		this.petImage = petImage;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetRasa() {
		return petRasa;
	}
	public void setPetRasa(String petRasa) {
		this.petRasa = petRasa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPetId() {
		String strI = Integer.toString(getId());
		return strI;
	}
	public Pet(String name, String rasa, int id, Image image, LocalDate time) {
		setPetName(name);
		setPetRasa(rasa);
		setId(id);		
		setPetImage(image);
		setPetTime(time);
	}
	public Pet() {}
}

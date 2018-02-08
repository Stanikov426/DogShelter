package pl.stanikov.app.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Pet{
	private String petName;
	private String petRasa;
	private Image petImage;
	private LocalDate petDate;
	private String filePath;
	private File file;
	private int id;
	
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		File test = new File(getFilePath());
		setFile(test);
		try {
            BufferedImage bufferedImage = ImageIO.read(test);;
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            setPetImage(image);
        } catch (IOException ex) {
            System.out.println("Zdjecie nie zostalo stworzone");
        }
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getPetTime() {
		DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String format = petDate.format(formatter_2);
		return format;
	}
	public void setPetTime(LocalDate petTime) {
		this.petDate = petTime;
	}
	
	public void setPetDate(String petTime) {
		DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dt = LocalDate.parse(petTime, formatter_2);
		this.petDate = dt;
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
	public Pet(String name, String rasa, int id, Image image, LocalDate time, File file) {
		setPetName(name);
		setPetRasa(rasa);
		setId(id);		
		setPetImage(image);
		setPetTime(time);
		setFile(file);
		setFilePath(file.getPath());
	}
	public Pet() {}
}

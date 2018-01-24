package pl.stanikov.app.main;



public class Pet{
	private String petName;
	private String petRasa;
	private int id;
	
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
	public Pet(String name, String rasa, int id) {
		setPetName(name);
		setPetRasa(rasa);
		setId(id);
	}
	public Pet() {}
}

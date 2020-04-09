package vol.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Particulier")
public class Particulier extends Client{
	private String prenom;
	
	//Generator
	
	public Particulier() {
		super();
	}

	//Getters and setters
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//toString

	@Override
	public String toString() {
		return "Particulier [prenom=" + prenom + super.toString() +"]";
	}
	
	

	

}

package vol.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Societe")
public class Societe extends Client{
	
	private String siret;
	private String numeroDeTva;
	
	//Generator
	
	public Societe() {
		super();
	}
	
	//Getters and setters
		
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getNumeroDeTva() {
		return numeroDeTva;
	}
	public void setNumeroDeTva(String numeroDeTva) {
		this.numeroDeTva = numeroDeTva;
	}

	@Override
	public String toString() {
		return "Societe [siret=" + siret + ", numeroDeTva=" + numeroDeTva + super.toString() +"]";
	}
	
}

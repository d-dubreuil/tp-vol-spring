package vol.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Embeddable
public class Arrivee {
	private Date dateArrivee;
	@ManyToOne
	@JoinColumn(name="aeroport_id_arrivee")
	private Aeroport aeroport;
	
	public Arrivee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public Aeroport getAeroprt() {
		return aeroport;
	}
	public void setAeroprt(Aeroport aeroprt) {
		this.aeroport = aeroprt;
	}
	
	@Override
	public String toString() {
		return "Arrivee [dateArrivee=" + dateArrivee + ", aeroport=" + aeroport + "]";
	}
	
	
	
	
	
	

}

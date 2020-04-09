package vol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Depart {
	@Column(name = "datedepart", length = 255)
	private Date dateDepart;
	@ManyToOne
	@JoinColumn (name = "aeroport_id_depart")
	private Aeroport aeroport;
	
	public Depart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	@Override
	public String toString() {
		return "Depart [dateDepart=" + dateDepart + ", aeroport=" + aeroport + "]";
	}
	
	
	

}

package vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Paiement {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String type;
	@Column(nullable = false)
	private Float montant;
	@OneToOne
	@JoinColumn(name="reservation_id")
	private Reservation reservation;
	
	//generator
	
	public Paiement() {
		super();
	}
	public Paiement(String type, Float montant) {
		super();
		this.type = type;
		this.montant = montant;
	}
	
	//Getters and setters
	
	public String getType() {
		return type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getMontant() {
		return montant;
	}
	public void setMontant(Float montant) {
		this.montant = montant;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Paiement [type=" + type + ", montant=" + montant + "]";
	}
	
	
	

}

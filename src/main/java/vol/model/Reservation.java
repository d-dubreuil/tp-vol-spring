package vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private Boolean annulee;
	private Boolean confirmee;
	private Boolean ouverte;
	@Column (nullable = false)
	private String numeroDeReservation;
	@ManyToOne
	@JoinColumn(name="passager_id")
	private Passager passager;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@OneToOne (mappedBy = "reservation")
	private Paiement paiement;
	@OneToOne(mappedBy = "res")
	private Trajet traj;
	
	//generator
	
	public Reservation() {
		super();
	}
	public Reservation(String numeroDeReservation) {
		super();
		this.numeroDeReservation = numeroDeReservation;
	}
	
	//Getters and setters
		
	public Boolean getAnnulee() {
		return annulee;
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
	public void setAnnulee(Boolean annulee) {
		this.annulee = annulee;
	}
	public Boolean getConfirmee() {
		return confirmee;
	}
	public void setConfirmee(Boolean confirmee) {
		this.confirmee = confirmee;
	}
	public Boolean getOuverte() {
		return ouverte;
	}
	public void setOuverte(Boolean ouverte) {
		this.ouverte = ouverte;
	}
	public String getNumeroDeReservation() {
		return numeroDeReservation;
	}
	public void setNumeroDeReservation(String numeroDeReservation) {
		this.numeroDeReservation = numeroDeReservation;
	}
	public Passager getPassager() {
		return passager;
	}
	public void setPassager(Passager passager) {
		this.passager = passager;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	
	
	//toString
	
	public Trajet getTraj() {
		return traj;
	}
	public void setTraj(Trajet traj) {
		this.traj = traj;
	}
	@Override
	public String toString() {
		return "Reservation [annulee=" + annulee + ", confirmee=" + confirmee + ", ouverte=" + ouverte
				+ ", numeroDeReservation=" + numeroDeReservation + ", passager=" + passager + ", client=" + client
				+ ", paiement=" + paiement + "]";
	}
	
	

}

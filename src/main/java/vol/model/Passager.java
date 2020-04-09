package vol.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Passager {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(nullable = false)
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String nationalite;
	private String sexe;
	@Column(nullable = false)
	private String numeroPasseport;
	private Date dateValidite;
	private String typePieceIdentite;
	private Boolean handicap;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@OneToMany (mappedBy = "passager")
	private List<Reservation>reservations = new ArrayList<Reservation>();
	
	// generator

	public Passager() {
		super();
	}
	
	// getters and setters

	public String getNom() {
		return nom;
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

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getNumeroPasseport() {
		return numeroPasseport;
	}
	public void setNumeroPasseport(String numeroPasseport) {
		this.numeroPasseport = numeroPasseport;
	}
	public Date getDateValidite() {
		return dateValidite;
	}
	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}
	public String getTypePieceIdentite() {
		return typePieceIdentite;
	}
	public void setTypePieceIdentite(String typePieceIdentite) {
		this.typePieceIdentite = typePieceIdentite;
	}
	public Boolean getHandicap() {
		return handicap;
	}
	public void setHandicap(Boolean handicap) {
		this.handicap = handicap;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	//Add
	
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}

	
	
	


	@Override
	public String toString() {
		return "Passager [nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + ", nationalite="
				+ nationalite + ", sexe=" + sexe + ", numeroPasseport=" + numeroPasseport + ", sateValidite="
				+ dateValidite + ", typePieceIdentite=" + typePieceIdentite + ", handicap=" + handicap + ", client="
				+ client + "]";
	}
	
	
	
	
	
	
	
	

}

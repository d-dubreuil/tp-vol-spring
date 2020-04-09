package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Client {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column (nullable = false)
	private String nom;
	@Column (nullable = false)
	private String mail;
	private String telephone;
	private Integer numeroAdresse;
	private Integer codePostal;
	private String rue;
	private String ville;
	private String complementAdresse;
	private String pays;
	@OneToOne (mappedBy = "client")
	private Utilisateur utilisateur;
	@OneToMany (mappedBy = "client")
	private List<Passager>passagers = new ArrayList<Passager>();
	@OneToMany (mappedBy = "client")
	private List<Reservation>reservations = new ArrayList<Reservation>();
	
	//Generator
	
	public Client() {
		super();
	}
	public Client(String nom, String type, String mail) {
		super();
		this.nom = nom;
		this.mail = mail;
	}

	//Getters and setters
	
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getNumeroAdresse() {
		return numeroAdresse;
	}
	public void setNumeroAdresse(Integer numeroAdresse) {
		this.numeroAdresse = numeroAdresse;
	}
	public Integer getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getComplementAdresse() {
		return complementAdresse;
	}
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Passager> getPassagers() {
		return passagers;
	}
	public void setPassagers(List<Passager> passagers) {
		this.passagers = passagers;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	//Add
	
	public void addPassager (Passager passager) {
		this.passagers.add(passager);
	}
	public void addReservation (Reservation reservation) {
		this.reservations.add(reservation);
	}
	
	
	
	

	@Override
	public String toString() {
		return "Client [nom=" + nom  + ", mail=" + mail + ", telephone=" + telephone
				+ ", numeroAdresse=" + numeroAdresse + ", codePostal=" + codePostal + ", rue=" + rue + ", ville="
				+ ville + ", complementAdresse=" + complementAdresse + ", pays=" + pays + ", utilisateur=" + utilisateur
				+ "]";
	}
	
	
	
	

}

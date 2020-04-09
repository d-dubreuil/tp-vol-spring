package vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(nullable = false)
	private String identifiant;
	@Column(nullable = false)
	private String motDePasse;
	@OneToOne
	@JoinColumn (name="client_id")
	private Client client;
	
	//generator
	
	public Utilisateur() {
		super();
	}	
	public Utilisateur(String identifiant, String motDePasse) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}

	//getters and setters
	
	public String getIdentifiant() {
		return identifiant;
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
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Utilisateur [identifiant=" + identifiant + ", motDePasse=" + motDePasse + "]";
	}
	
	
	
	
	

}

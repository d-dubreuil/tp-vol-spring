package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Vol {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column( length = 5)
	private String numeroDeVol;
	@Column(length = 100, nullable = false)
	private Boolean ouvert;
	@ManyToMany
	@JoinTable(name = "plan_de_vol",joinColumns = @JoinColumn(name="vol_id"),inverseJoinColumns = @JoinColumn(name="trajet_id")
	)
	private List<Trajet> trajets = new ArrayList<Trajet>();
	@ManyToOne
	@JoinColumn(name="compagnie_id")
	private Compagnie compagnie;
	@ManyToOne
	@JoinColumn(name="avion_id")
	private Avion avion;
	@Embedded
	private Arrivee arrivee;
	@Embedded
	private Depart depart;

	
	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumeroDeVol() {
		return numeroDeVol;
	}

	public void setNumeroDeVol(String numeroDeVol) {
		this.numeroDeVol = numeroDeVol;
	}

	public Boolean getOuvert() {
		return ouvert;
	}

	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(ArrayList<Trajet> trajets) {
		this.trajets = trajets;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Arrivee getArrivee() {
		return arrivee;
	}

	public void setArrivee(Arrivee arrivee) {
		this.arrivee = arrivee;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	
	public void addTrajet(Trajet trajet) {
		this.trajets.add(trajet);
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

	@Override
	public String toString() {
		return "Vol [numeroDeVol=" + numeroDeVol + ", ouvert=" + ouvert + ", compagnie=" + compagnie + ", avion="
				+ avion + ", arrivee=" + arrivee + ", depart=" + depart + "]";
	}
	




	
	
	
	
}

package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="Ville")
public class Ville {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "pays", nullable = false)
	private String pays;
	@ManyToMany(mappedBy="villes")
	private List<Aeroport> aeroports = new ArrayList<Aeroport>();
	
	public Ville() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public List<Aeroport> getAeroports() {
		return aeroports;
	}

	public void setAeroports(ArrayList<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}
	
	public void addAeroport(Aeroport aeroports) {
		this.aeroports.add(aeroports);
	}

	@Override
	public String toString() {
		return "Ville [nom=" + nom + ", pays=" + pays + "]";
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

	
	

}

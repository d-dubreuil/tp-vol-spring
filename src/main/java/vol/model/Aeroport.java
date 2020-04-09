package vol.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Aeroport")
public class Aeroport {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "nom", nullable = false)
	private String nom;
	@ManyToMany
	@JoinTable(name = "plan_des_aeroports",joinColumns = @JoinColumn(name="aeroport_id"),inverseJoinColumns = @JoinColumn(name="ville_id")
	)
	private List<Ville> villes = new ArrayList<Ville>();
	
	public Aeroport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(ArrayList<Ville> villes) {
		this.villes = villes;
	}
	

	public void addVille(Ville villes) {
		this.villes.add(villes);
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
		return "Aeroport [id=" + id + ", version=" + version + ", nom=" + nom + "]";
	}
	
	
	
}

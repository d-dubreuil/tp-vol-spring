package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Compagnie {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(nullable = false)
	private String nom;
	@OneToMany (mappedBy = "compagnie")
	private List<Vol> vols	 = new ArrayList<Vol>();
	
	public Compagnie() {
		super();
		// TODO Auto-generated constructor stub
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



	public Compagnie(String nom) {
		super();
		this.nom = nom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public List<Vol> getVols() {
		return vols;
	}



	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}



	public void addVol(Vol vols) {
		this.vols.add(vols);
	}



	@Override
	public String toString() {
		return "Compagnie [nom=" + nom + "]";
	}
	



	
	
}

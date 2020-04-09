package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Avion {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	
	private String modele;
	@OneToMany (mappedBy = "avion")
	private List<Vol> vols	 = new ArrayList<Vol>();
	
	public Avion() {
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



	public Avion(String modele) {
		super();
		this.modele = modele;
	}



	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public List<Vol> getVols() {
		return vols;
	}


	public void setVols(ArrayList<Vol> vols) {
		this.vols = vols;
	}


	public void addVol(Vol vols) {
		this.vols.add(vols);
	}



	@Override
	public String toString() {
		return "Avion [modele=" + modele + "]";
	}





	


	



	
	
	

}

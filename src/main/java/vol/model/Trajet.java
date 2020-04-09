package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Trajet {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToMany (mappedBy = "trajets")
	private List<Vol> volsOrdonne = new ArrayList<Vol>();
	@OneToOne
	@JoinColumn(name="reservation_id")
	private Reservation res;
	
	public Trajet() {
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

	public List<Vol> getVolsOrdonne() {
		return volsOrdonne;
	}

	public void setVolsOrdonne(ArrayList<Vol> volsOrdonne) {
		this.volsOrdonne = volsOrdonne;
	}

	
	public void AddVol(Vol volsOrdonne) {
		this.volsOrdonne.add(volsOrdonne);
	}

	public Reservation getRes() {
		return res;
	}

	public void setRes(Reservation res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return "Trajet [volsOrdonne=" + volsOrdonne + ", res=" + res + "]";
	}


	
	

}

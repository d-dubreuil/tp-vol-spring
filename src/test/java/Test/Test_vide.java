package Test;

import java.util.Date;

import vol.model.Aeroport;
import vol.model.Arrivee;
import vol.model.Avion;
import vol.model.Compagnie;
import vol.model.Depart;
import vol.model.Paiement;
import vol.model.Particulier;
import vol.model.Passager;
import vol.model.Reservation;
import vol.model.Societe;
import vol.model.Trajet;
import vol.model.Utilisateur;
import vol.model.Ville;
import vol.model.Vol;
import vol.singleton.Application;

public class Test_vide {

	public static void main(String[] args) {
		testCRUD();

	}

	public static void creationDonnees() {

		Societe sopraSteria = new Societe();
		sopraSteria.setSiret("1234");
		sopraSteria.setNumeroDeTva("5454");
		sopraSteria.setNom("Sopra Steria");
		sopraSteria.setCodePostal(33700);
		sopraSteria.setMail("mlskqsd@qlksjd.qsd");
		sopraSteria.setTelephone("06.48.54.21.32");
		sopraSteria.setNumeroAdresse(5);
		sopraSteria.setRue("rue de mlqksd");
		sopraSteria.setVille("Mérignac");
		sopraSteria.setComplementAdresse(null);
		sopraSteria.setPays("France");

		sopraSteria = Application.getInstance().getSocieteDao().save(sopraSteria); // managed

		Particulier moi = new Particulier();
		moi.setPrenom("Damien");
		moi.setNom("Dubreuil");
		moi.setCodePostal(33610);
		moi.setMail("dubreuil.damien@laposte.net");
		moi.setTelephone("06.45.87.20.52");
		moi.setNumeroAdresse(5);
		moi.setRue("impasse de Granet");
		moi.setVille("Canéjan");
		moi.setComplementAdresse(null);
		moi.setPays("France");
		
		
		moi = Application.getInstance().getParticulierDao().save(moi); // managed

		Utilisateur user = new Utilisateur();
		user.setIdentifiant("ddub");
		user.setMotDePasse("azerty");
		user.setClient(moi);

		user = Application.getInstance().getUtilisateurDao().save(user);

		Passager toi = new Passager();
		toi.setNom("Ujsdhf");
		toi.setPrenom("Clement");
		toi.setDateDeNaissance(new Date());
		toi.setNationalite("francaise");
		toi.setSexe("H");
		toi.setNumeroPasseport("qsdlk");
		toi.setDateValidite(new Date());
		toi.setTypePieceIdentite("passeport");
		toi.setHandicap(false);
		toi.setClient(moi);

		toi = Application.getInstance().getPassagerDao().save(toi); // managed

		Reservation res = new Reservation();
		res.setAnnulee(false);
		res.setConfirmee(true);
		res.setOuverte(true);
		res.setNumeroDeReservation("46579845");
		res.setClient(moi);
		res.setPassager(toi);

		res = Application.getInstance().getReservationDao().save(res); // managed

		Paiement paiement = new Paiement();
		paiement.setMontant(54.56f);
		paiement.setType("CB");
		paiement.setReservation(res);

		paiement = Application.getInstance().getPaiementDao().save(paiement); // managed

		res.setPaiement(paiement);
		res = Application.getInstance().getReservationDao().save(res); // managed

		Ville paris = new Ville();
		paris.setNom("Paris");
		paris.setPays("France");

		paris = Application.getInstance().getVilleDao().save(paris);

		Aeroport roisy = new Aeroport();
		roisy.setNom("Roisy");
		roisy.addVille(paris);

		roisy = Application.getInstance().getAeroportDao().save(roisy);

		paris.addAeroport(roisy);
		paris = Application.getInstance().getVilleDao().save(paris);

		Depart dep = new Depart();
		dep.setAeroport(roisy);
		dep.setDateDepart(new Date());

		Arrivee arr = new Arrivee();
		arr.setAeroprt(roisy);
		arr.setDateArrivee(new Date());

		Avion airbus = new Avion();
		airbus.setModele("Airbus A 320");

		airbus = Application.getInstance().getAvionDao().save(airbus);

		Compagnie airfrance = new Compagnie();
		airfrance.setNom("Air France");

		airfrance = Application.getInstance().getCompagnieDao().save(airfrance);

		Vol vol1 = new Vol();
		vol1.setNumeroDeVol("65498");
		vol1.setOuvert(true);
		vol1.setDepart(dep);
		vol1.setArrivee(arr);
		vol1.setAvion(airbus);
		vol1.setCompagnie(airfrance);

		vol1 = Application.getInstance().getVolDao().save(vol1);

		Trajet traj = new Trajet();
		traj.setRes(res);
		res.setTraj(traj);

		traj = Application.getInstance().getTrajetDao().save(traj);
		vol1.addTrajet(traj);
		vol1 = Application.getInstance().getVolDao().save(vol1);
	}

	public static void testCRUD() {
		Societe sopraSteria = new Societe();
		sopraSteria.setSiret("1234");
		sopraSteria.setNumeroDeTva("5454");
		sopraSteria.setNom("Sopra Steria");
		sopraSteria.setCodePostal(33700);
		sopraSteria.setMail("mlskqsd@qlksjd.qsd");
		sopraSteria.setTelephone("06.48.54.21.32");
		sopraSteria.setNumeroAdresse(5);
		sopraSteria.setRue("rue de mlqksd");
		sopraSteria.setVille("Merignac");
		sopraSteria.setComplementAdresse(null);
		sopraSteria.setPays("France");

		sopraSteria = Application.getInstance().getSocieteDao().save(sopraSteria);
		
		System.out.println(Application.getInstance().getSocieteDao().find(sopraSteria.getId()));

		sopraSteria.setPays("Allemagne");
		sopraSteria = Application.getInstance().getSocieteDao().save(sopraSteria);
		System.out.println(Application.getInstance().getSocieteDao().find(sopraSteria.getId()));
		
		System.out.println(Application.getInstance().getSocieteDao().findAll());
		Application.getInstance().getSocieteDao().delete(sopraSteria);
		System.out.println(Application.getInstance().getSocieteDao().findAll());
	}
}

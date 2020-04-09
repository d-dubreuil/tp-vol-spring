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



public class Test {
	public static void main(String[] args) {

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
		
		Particulier moi = new Particulier();
		moi.setPrenom("Damien");
		moi.setNom("Dubreuil");
		moi.setCodePostal(33610);
		moi.setMail("dubreuil.damien@laposte.net");
		moi.setTelephone("06.45.87.20.52");
		moi.setNumeroAdresse(5);
		moi.setRue("impasse de Granet");
		moi.setVille("Can�jan");
		moi.setComplementAdresse(null);
		moi.setPays("France");
		
		
		Utilisateur user = new Utilisateur();
		user.setIdentifiant("ddub");
		user.setMotDePasse("azerty");
		user.setClient(moi);
		
		moi.setUtilisateur(user);
		
		
		Passager toi = new Passager();
		toi.setNom("Ujsdhf");
		toi.setPrenom("Cl�ment");
		toi.setDateDeNaissance(new Date());
		toi.setNationalite("fran�aise");
		toi.setSexe("H");
		toi.setNumeroPasseport("qsdlk");
		toi.setDateValidite(new Date());
		toi.setTypePieceIdentite("passeport");
		toi.setHandicap(false);
		toi.setClient(moi);
		
		moi.addPassager(toi);
		
		
		Reservation res = new Reservation();
		res.setAnnulee(false);
		res.setConfirmee(true);
		res.setOuverte(true);
		res.setNumeroDeReservation("46579845");
		res.setClient(moi);
		res.setPassager(toi);
		
		moi.addReservation(res);
		toi.addReservation(res);
		
		
		Paiement paiement = new Paiement();
		paiement.setMontant(54.56f);
		paiement.setType("CB");
		paiement.setReservation(res);
		
		res.setPaiement(paiement);
		
		Ville paris = new Ville();
		paris.setNom("Paris");
		paris.setPays("France");
		
		Aeroport roisy = new Aeroport();
		roisy.setNom("Roisy");
		roisy.addVille(paris);
		
		paris.addAeroport(roisy);
		
		
		Depart dep = new Depart();
		dep.setAeroport(roisy);
		dep.setDateDepart(new Date());
		
		Arrivee arr = new Arrivee();
		arr.setAeroprt(roisy);
		arr.setDateArrivee(new Date());
		
		Avion airbus = new Avion();
		airbus.setModele("Airbus A 320");
		
		Compagnie airfrance = new Compagnie();
		airfrance.setNom("Air France");
		
		Vol vol1 = new Vol();
		vol1.setNumeroDeVol("65498412");
		vol1.setOuvert(true);
		vol1.setDepart(dep);
		vol1.setArrivee(arr);
		vol1.setAvion(airbus);
		vol1.setCompagnie(airfrance);
		
		airfrance.addVol(vol1);
		airbus.addVol(vol1);
		
		Trajet traj = new Trajet();
		traj.AddVol(vol1);
		traj.setRes(res);
		
		res.setTraj(traj);
		vol1.addTrajet(traj);
		
		System.out.println(traj);
		
		
		
		
	
	
	}
}

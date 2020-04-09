package Test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import vol.DAO.interfaces.IAeroportDao;
import vol.DAO.interfaces.IAvionDao;
import vol.DAO.interfaces.ICompagnieDao;
import vol.DAO.interfaces.IPaiementDao;
import vol.DAO.interfaces.IParticulierDao;
import vol.DAO.interfaces.IPassagerDao;
import vol.DAO.interfaces.IReservationDao;
import vol.DAO.interfaces.ISocieteDao;
import vol.DAO.interfaces.ITrajetDao;
import vol.DAO.interfaces.IUtilisateurDao;
import vol.DAO.interfaces.IVilleDao;
import vol.DAO.interfaces.IVolDao;
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

public class Test_vide {

	public static void main(String[] args) {
		creationDonnees();

	}

	public static void creationDonnees() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		IAeroportDao aeroportDao = context.getBean(IAeroportDao.class);
		IAvionDao avionDao = context.getBean(IAvionDao.class);
		ICompagnieDao compagnieDao = context.getBean(ICompagnieDao.class);
		IPaiementDao paiementDao = context.getBean(IPaiementDao.class);
		IParticulierDao particulierDao = context.getBean(IParticulierDao.class);
		IPassagerDao passagerDao = context.getBean(IPassagerDao.class);
		IReservationDao reservationDao = context.getBean(IReservationDao.class);
		ISocieteDao societeDao = context.getBean(ISocieteDao.class);
		ITrajetDao trajetDao = context.getBean(ITrajetDao.class);
		IUtilisateurDao utilisateurDao = context.getBean(IUtilisateurDao.class);
		IVilleDao villeDao = context.getBean(IVilleDao.class);
		IVolDao volDao = context.getBean(IVolDao.class);

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

		sopraSteria = societeDao.save(sopraSteria); // managed

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
		
		
		moi = particulierDao.save(moi); // managed

		Utilisateur user = new Utilisateur();
		user.setIdentifiant("ddub");
		user.setMotDePasse("azerty");
		user.setClient(moi);

		user = utilisateurDao.save(user);

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

		toi = passagerDao.save(toi); // managed

		Reservation res = new Reservation();
		res.setAnnulee(false);
		res.setConfirmee(true);
		res.setOuverte(true);
		res.setNumeroDeReservation("46579845");
		res.setClient(moi);
		res.setPassager(toi);

		res = reservationDao.save(res); // managed

		Paiement paiement = new Paiement();
		paiement.setMontant(54.56f);
		paiement.setType("CB");
		paiement.setReservation(res);

		paiement = paiementDao.save(paiement); // managed

		res.setPaiement(paiement);
		res = reservationDao.save(res); // managed

		Ville paris = new Ville();
		paris.setNom("Paris");
		paris.setPays("France");

		paris = villeDao.save(paris);

		Aeroport roisy = new Aeroport();
		roisy.setNom("Roisy");
		roisy.addVille(paris);

		roisy = aeroportDao.save(roisy);

		paris.addAeroport(roisy);
		paris = villeDao.save(paris);

		Depart dep = new Depart();
		dep.setAeroport(roisy);
		dep.setDateDepart(new Date());

		Arrivee arr = new Arrivee();
		arr.setAeroprt(roisy);
		arr.setDateArrivee(new Date());

		Avion airbus = new Avion();
		airbus.setModele("Airbus A 320");

		airbus = avionDao.save(airbus);

		Compagnie airfrance = new Compagnie();
		airfrance.setNom("Air France");

		airfrance = compagnieDao.save(airfrance);

		Vol vol1 = new Vol();
		vol1.setNumeroDeVol("65498");
		vol1.setOuvert(true);
		vol1.setDepart(dep);
		vol1.setArrivee(arr);
		vol1.setAvion(airbus);
		vol1.setCompagnie(airfrance);

		vol1 = volDao.save(vol1);

		Trajet traj = new Trajet();
		traj.setRes(res);
		res.setTraj(traj);

		traj = trajetDao.save(traj);
		vol1.addTrajet(traj);
		vol1 = volDao.save(vol1);
	}

	public static void testCRUD() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		ISocieteDao societeDao = context.getBean(ISocieteDao.class);

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

		sopraSteria = societeDao.save(sopraSteria);
		
		System.out.println(societeDao.find(sopraSteria.getId()));

		sopraSteria.setPays("Allemagne");
		sopraSteria = societeDao.save(sopraSteria);
		System.out.println(societeDao.find(sopraSteria.getId()));
		
		System.out.println(societeDao.findAll());
		societeDao.delete(sopraSteria);
		System.out.println(societeDao.findAll());
	}
}

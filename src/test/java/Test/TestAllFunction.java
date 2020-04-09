package Test;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

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
import vol.DAO.jpa.SocieteDaoJpa;
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
import vol.model.Ville;
import vol.model.Vol;

public class TestAllFunction {

	public static void main(String[] args) {
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
		
		sopraSteria = save(sopraSteria); // managed
		sopraSteria = Application.getInstance().getSocieteDao().find(sopraSteria.getId());
		System.out.println(sopraSteria);
		List<Societe> societes = new ArrayList<Societe>();
		societes = Application.getInstance().getSocieteDao().findAll();
		System.out.println(societes);
		Application.getInstance().getSocieteDao().delete(sopraSteria);
	
		
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
		Particulier moi2 = new Particulier();
		moi2 = Application.getInstance().getParticulierDao().find(moi.getId());
		System.out.println(moi);
		List<Particulier> particuliers = new ArrayList<Particulier>();
		particuliers = Application.getInstance().getParticulierDao().findAll();
		System.out.println(particuliers);
		Application.getInstance().getParticulierDao().delete(moi2);
		moi = Application.getInstance().getParticulierDao().save(moi); // managed
		
		Passager toi = new Passager();
		toi.setNom("Ujsdhf");
		toi.setPrenom("Clément");
		toi.setDateDeNaissance(new Date());
		toi.setNationalite("française");
		toi.setSexe("H");
		toi.setNumeroPasseport("qsdlk");
		toi.setDateValidite(new Date());
		toi.setTypePieceIdentite("passeport");
		toi.setHandicap(false);
		toi.setClient(moi);
//		
		toi = Application.getInstance().getPassagerDao().save(toi); // managed
		toi = Application.getInstance().getPassagerDao().find(toi.getId());
		System.out.println(toi);
		List<Passager> passagers = new ArrayList<Passager>();
		passagers = Application.getInstance().getPassagerDao().findAll();
		System.out.println(passagers);
		Application.getInstance().getPassagerDao().delete(toi);
		toi = Application.getInstance().getPassagerDao().save(toi); // managed	
		
		moi.addPassager(toi);
		moi = Application.getInstance().getParticulierDao().save(moi); // managed
		
		
		
		
		
		
		
	}

}

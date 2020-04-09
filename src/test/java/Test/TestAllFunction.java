package Test;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import vol.DAO.interfaces.IParticulierDao;
import vol.DAO.interfaces.IPassagerDao;
import vol.DAO.interfaces.ISocieteDao;
import vol.model.Particulier;
import vol.model.Passager;
import vol.model.Societe;

public class TestAllFunction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		IParticulierDao particulierDao = context.getBean(IParticulierDao.class);
		IPassagerDao passagerDao = context.getBean(IPassagerDao.class);
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
		sopraSteria.setVille("Mérignac");
		sopraSteria.setComplementAdresse(null);
		sopraSteria.setPays("France");
		
		sopraSteria = societeDao.save(sopraSteria); // managed
		sopraSteria = societeDao.find(sopraSteria.getId());
		System.out.println(sopraSteria);
		List<Societe> societes = new ArrayList<Societe>();
		societes = societeDao.findAll();
		System.out.println(societes);
		societeDao.delete(sopraSteria);
	
		
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
		Particulier moi2 = new Particulier();
		moi2 = particulierDao.find(moi.getId());
		System.out.println(moi);
		List<Particulier> particuliers = new ArrayList<Particulier>();
		particuliers = particulierDao.findAll();
		System.out.println(particuliers);
		particulierDao.delete(moi2);
		moi = particulierDao.save(moi); // managed
		
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
		toi = passagerDao.save(toi); // managed
		toi = passagerDao.find(toi.getId());
		System.out.println(toi);
		List<Passager> passagers = new ArrayList<Passager>();
		passagers = passagerDao.findAll();
		System.out.println(passagers);
		passagerDao.delete(toi);
		toi = passagerDao.save(toi); // managed	
		
		moi.addPassager(toi);
		moi = particulierDao.save(moi); // managed
		
		
		
		
		
		
		
	}

}

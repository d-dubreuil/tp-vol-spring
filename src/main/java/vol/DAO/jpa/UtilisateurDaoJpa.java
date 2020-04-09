package vol.DAO.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vol.DAO.interfaces.IUtilisateurDao;
import vol.model.Utilisateur;
import vol.singleton.Application;



public class UtilisateurDaoJpa implements IUtilisateurDao {


	@Override

	public List<Utilisateur> findAll() {

		List<Utilisateur> utilisateurs = null;


		EntityManager em = null;

		EntityTransaction tx = null;


		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();


			TypedQuery<Utilisateur> query = em.createQuery("from Utilisateur", Utilisateur.class);



			utilisateurs = query.getResultList();


			tx.commit();

		} catch (Exception e) {

			if (tx != null && tx.isActive()) {

				tx.rollback();

			}

			e.printStackTrace();

		} finally {

			if (em != null) {

				em.close();

			}

		}


		return utilisateurs;

	}



	@Override

	public Utilisateur find(Long id) {

		Utilisateur utilisateur = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			utilisateur = em.find(Utilisateur.class, id);



			tx.commit();

		} catch (Exception e) {

			if (tx != null && tx.isActive()) {

				tx.rollback();

			}

			e.printStackTrace();

		} finally {

			if (em != null) {

				em.close();

			}

		}



		return utilisateur;

	}



	@Override

	public Utilisateur save(Utilisateur obj) {

		Utilisateur utilisateur = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			utilisateur = em.merge(obj);



			tx.commit();

		} catch (Exception e) {

			if (tx != null && tx.isActive()) {

				tx.rollback();

			}

			e.printStackTrace();

		} finally {

			if (em != null) {

				em.close();

			}

		}

		return utilisateur;

	}


	@Override

	public void delete(Utilisateur obj) {

		EntityManager em = null;

		EntityTransaction tx = null;


		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();


			em.remove(em.merge(obj));



			tx.commit();

		} catch (Exception e) {

			if (tx != null && tx.isActive()) {

				tx.rollback();

			}

			e.printStackTrace();

		} finally {

			if (em != null) {

				em.close();

			}

		}

	}

}



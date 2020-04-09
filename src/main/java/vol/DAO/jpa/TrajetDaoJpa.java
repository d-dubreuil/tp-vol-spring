package vol.DAO.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vol.DAO.interfaces.ITrajetDao;
import vol.model.Trajet;
import vol.singleton.Application;



public class TrajetDaoJpa implements ITrajetDao {


	@Override

	public List<Trajet> findAll() {

		List<Trajet> trajets = null;


		EntityManager em = null;

		EntityTransaction tx = null;


		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();


			TypedQuery<Trajet> query = em.createQuery("from Trajet", Trajet.class);



			trajets = query.getResultList();


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


		return trajets;

	}



	@Override

	public Trajet find(Long id) {

		Trajet trajet = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			trajet = em.find(Trajet.class, id);



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



		return trajet;

	}



	@Override

	public Trajet save(Trajet obj) {

		Trajet trajet = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			trajet = em.merge(obj);



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

		return trajet;

	}


	@Override

	public void delete(Trajet obj) {

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



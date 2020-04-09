package vol.DAO.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vol.DAO.interfaces.IVilleDao;
import vol.model.Ville;
import vol.singleton.Application;



public class VilleDaoJpa implements IVilleDao {


	@Override

	public List<Ville> findAll() {

		List<Ville> villes = null;


		EntityManager em = null;

		EntityTransaction tx = null;


		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();


			TypedQuery<Ville> query = em.createQuery("from Ville", Ville.class);



			villes = query.getResultList();


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


		return villes;

	}



	@Override

	public Ville find(Long id) {

		Ville ville = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			ville = em.find(Ville.class, id);



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



		return ville;

	}



	@Override

	public Ville save(Ville obj) {

		Ville ville = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			ville = em.merge(obj);



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

		return ville;

	}


	@Override

	public void delete(Ville obj) {

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



package vol.DAO.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vol.DAO.interfaces.ISocieteDao;
import vol.model.Societe;
import vol.singleton.Application;



public class SocieteDaoJpa implements ISocieteDao {


	@Override

	public List<Societe> findAll() {

		List<Societe> societes = null;


		EntityManager em = null;

		EntityTransaction tx = null;


		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();


			TypedQuery<Societe> query = em.createQuery("from Societe", Societe.class);



			societes = query.getResultList();


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


		return societes;

	}



	@Override

	public Societe find(Long id) {

		Societe societe = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			societe = em.find(Societe.class, id);



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



		return societe;

	}



	@Override

	public Societe save(Societe obj) {

		Societe societe = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			societe = em.merge(obj);



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

		return societe;

	}


	@Override

	public void delete(Societe obj) {

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



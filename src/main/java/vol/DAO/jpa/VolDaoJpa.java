package vol.DAO.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vol.DAO.interfaces.IVolDao;
import vol.model.Vol;
import vol.singleton.Application;



public class VolDaoJpa implements IVolDao {


	@Override

	public List<Vol> findAll() {

		List<Vol> vols = null;


		EntityManager em = null;

		EntityTransaction tx = null;


		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();


			TypedQuery<Vol> query = em.createQuery("from Vol", Vol.class);



			vols = query.getResultList();


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


		return vols;

	}



	@Override

	public Vol find(Long id) {

		Vol vol = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			vol = em.find(Vol.class, id);



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



		return vol;

	}



	@Override

	public Vol save(Vol obj) {

		Vol vol = null;



		EntityManager em = null;

		EntityTransaction tx = null;



		try {

			em = Application.getInstance().getEmf().createEntityManager();

			tx = em.getTransaction();

			tx.begin();



			vol = em.merge(obj);



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

		return vol;

	}


	@Override

	public void delete(Vol obj) {

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



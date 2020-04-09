package vol.DAO.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.DAO.interfaces.IReservationDao;
import vol.model.Reservation;

@Repository
@Transactional
public class ReservationDaoJpa implements IReservationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Reservation> findAll() {
		TypedQuery<Reservation> query = em.createQuery("from Reservation", Reservation.class);
		return query.getResultList();
	}

	@Override
	public Reservation find(Long id) {
		return em.find(Reservation.class, id);
	}

	@Override
	public Reservation save(Reservation obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Reservation obj) {
		em.remove(em.merge(obj));
	}

}

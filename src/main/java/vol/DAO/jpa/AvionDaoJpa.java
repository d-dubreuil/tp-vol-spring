package vol.DAO.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.DAO.interfaces.IAvionDao;
import vol.model.Avion;

@Repository
@Transactional
public class AvionDaoJpa implements IAvionDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Avion> findAll() {
		TypedQuery<Avion> query = em.createQuery("from Avion", Avion.class);
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Avion find(Long id) {
		return em.find(Avion.class, id);
	}

	@Override
	public Avion save(Avion obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Avion obj) {
		em.remove(em.merge(obj));
	}

}

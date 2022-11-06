package it.prova.gestionebigliettiweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionebigliettiweb.model.Biglietto;

public class BigliettoDAOImp implements BigliettoDAO {

	private EntityManager entityManager;
	@Override
	public List<Biglietto> list() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Biglietto", Biglietto.class).getResultList();
	}

	@Override
	public Biglietto findOne(Long id) throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Biglietto where id=:id", Biglietto.class).setParameter("id", id).getResultStream().findFirst().orElse(null);
	}

	@Override
	public void update(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		entityManager.merge(input);
	}

	@Override
	public void insert(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		entityManager.persist(entityManager.merge(input));
	}

	@Override
	public void delete(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		this.entityManager=entityManager;
	}

}

package it.prova.gestionebigliettiweb.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.web.listener.LocalEntityManagerFactoryListener;

public class BigliettoServiceImp implements BigliettoService {

	private BigliettoDAO bigliettoDAO;

	@Override
	public List<Biglietto> findByExample(Biglietto biglietto) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			bigliettoDAO.setEntityManager(entityManager);

			return bigliettoDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public List<Biglietto> list() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			bigliettoDAO.setEntityManager(entityManager);

			return bigliettoDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Biglietto findOne(Long id) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			bigliettoDAO.setEntityManager(entityManager);

			return bigliettoDAO.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void update(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();

			bigliettoDAO.setEntityManager(entityManager);

			bigliettoDAO.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void insert(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();

			bigliettoDAO.setEntityManager(entityManager);

			bigliettoDAO.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();

			bigliettoDAO.setEntityManager(entityManager);

			bigliettoDAO.delete(bigliettoDAO.findOne(id));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void setBigliettoDAO(BigliettoDAO bigliettoDAO) {
		// TODO Auto-generated method stub
		this.bigliettoDAO = bigliettoDAO;
	}

}

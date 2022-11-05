package it.prova.gestionebigliettiweb.service;

import java.util.List;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.model.Biglietto;

public interface BigliettoService {

	public List<Biglietto> list() throws Exception;

	public Biglietto findOne(Long id) throws Exception;

	public void update(Biglietto input) throws Exception;

	public void insert(Biglietto input) throws Exception;

	public void delete(Long id) throws Exception;

	public void setBigliettoDAO(BigliettoDAO bigliettoDAO);
}

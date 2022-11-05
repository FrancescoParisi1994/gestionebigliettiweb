package it.prova.gestionebigliettiweb.service;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.dao.BigliettoDAOImp;

public class MyServiceFactory {

	private static BigliettoDAO bigliettoDAO = null;

	private static BigliettoService bigliettoService = null;

	public static BigliettoService getBigliettoServiceInstance() {

		if (bigliettoService == null) {
			bigliettoService = new BigliettoServiceImp();
		}

		if (bigliettoDAO == null) {
			bigliettoDAO = new BigliettoDAOImp();
		}

		bigliettoService.setBigliettoDAO(bigliettoDAO);

		return bigliettoService;
	}
}

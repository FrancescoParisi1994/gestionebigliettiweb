package it.prova.gestionebigliettiweb.web.servlet.execute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.BigliettoService;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;
import it.prova.gestionebigliettiweb.utility.Utility;

/**
 * Servlet implementation class ExecuteDeleteServlet
 */
@WebServlet("/ExecuteUpdateBigliettoServlet")
public class ExecuteUpdateBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BigliettoService bigliettoService = MyServiceFactory.getBigliettoServiceInstance();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idArticolo");

		if (!NumberUtils.isCreatable(idString)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		String provenienzaDaPagina = request.getParameter("provenienza");
		String destinazioneDaPagina = request.getParameter("destinazione");
		String dataDaPaginaString = request.getParameter("data");
		String prezzoDaPaginaString = request.getParameter("prezzo");

		Biglietto tempBiglietto = Utility.bicreateArticoloFromParams(provenienzaDaPagina, destinazioneDaPagina,
				prezzoDaPaginaString, dataDaPaginaString);

		if (!Utility.validateArticoloBean(tempBiglietto)) {
			request.setAttribute("visualizza_biglietto_attr", tempBiglietto);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione. Inserire i dati correttamente");
			request.getRequestDispatcher("/biglietto/update.jsp").forward(request, response);
			return;
		}

		tempBiglietto.setId(Long.parseLong(idString));
		try {
			bigliettoService.update(tempBiglietto);
			
			request.setAttribute("listaBigliettoAttribute", bigliettoService.list());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("visualizza_biglietto_attr", tempBiglietto);
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore provare e reinserire.");
			request.getRequestDispatcher("/biglietto/update.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);
	}

}

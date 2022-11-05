package it.prova.gestionebigliettiweb.web.servlet.execute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.BigliettoService;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;
import it.prova.gestionebigliettiweb.utility.Utility;

/**
 * Servlet implementation class ExecuteInsertBigliettoServlet
 */
@WebServlet("/ExecuteInsertBigliettoServlet")
public class ExecuteInsertBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BigliettoService bigliettoService = MyServiceFactory.getBigliettoServiceInstance();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String provenienzaDaPagina = request.getParameter("provenienza");
		String destinazioneDaPagina = request.getParameter("destinazione");
		String dataDaPaginaString = request.getParameter("data");
		String prezzoDaPaginaString = request.getParameter("prezzo");

		Biglietto tempBiglietto = Utility.bicreateArticoloFromParams(provenienzaDaPagina, destinazioneDaPagina,
				prezzoDaPaginaString, dataDaPaginaString);

		if (!Utility.validateArticoloBean(tempBiglietto)) {
			request.setAttribute("insert_biglietto_attr", tempBiglietto);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/biglietto/insert.jsp").forward(request, response);
			return;
		}

		try {
			bigliettoService.insert(tempBiglietto);

			request.setAttribute("listaBigliettoAttribute", bigliettoService.list());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore provare e reinserire.");
			request.getRequestDispatcher("/biglietto/insert.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);
	}

}

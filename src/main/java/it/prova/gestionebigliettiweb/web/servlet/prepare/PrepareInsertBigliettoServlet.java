package it.prova.gestionebigliettiweb.web.servlet.prepare;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.BigliettoService;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareInsertBigliettoServlet
 */
@WebServlet("/PrepareInsertBigliettoServlet")
public class PrepareInsertBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BigliettoService bigliettoService = MyServiceFactory.getBigliettoServiceInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("insert_biglietto_attr", new Biglietto());
		request.getRequestDispatcher("biglietto/insert.jsp").forward(request, response);
	}

}

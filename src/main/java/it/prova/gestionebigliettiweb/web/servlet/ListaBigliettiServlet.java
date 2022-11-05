package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.service.BigliettoService;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;

/**
 * Servlet implementation class ListaBigliettiServlet
 */
@WebServlet("/ListaBigliettiServlet")
public class ListaBigliettiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BigliettoService bigliettoService = MyServiceFactory.getBigliettoServiceInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("listaBigliettoAttribute", bigliettoService.list());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("biglietto/results.jsp").forward(request, response);
	}

}

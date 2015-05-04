package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Klant;
import dao.DAOFactory;
import dao.KlantDAO;

@WebServlet("/zoekKlant")
public class ZoekKlant extends HttpServlet {
	private KlantDAO klantdao = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getKlantDAO();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		List<Klant> klantlist = null;
		String id = request.getParameter("klantId");
		String name = request.getParameter("klantNaam");
		String format = request.getParameter("format");
		if (!(id == null || id.trim().equals(""))) {
			klantlist = klantdao.findById(Integer.parseInt(id));
		}
		if (!(name == null || name.trim().equals(""))) {
			klantlist = klantdao.findByName(name);
		}

		if (klantlist == null || klantlist.size() <= 0) {
			out.print("Geen klant gevonden");
		} else if ("json".equals(format)) {
			request.setAttribute("customers", klantlist);
			response.setContentType("application/json");
			String outputPage = "/results/customers-json.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
			dispatcher.include(request, response);
		} else {
			StringBuilder message = new StringBuilder();
			message.append("<table><tr><th>Naam</th><th>BTW</th></tr>");
			for (Klant klant : klantlist) {
				message.append("<tr><td>" + klant.getNaam() + "</td><td>" + klant.getBtw() + "</td></tr>");
			}
			message.append("</table>");
			out.print(message);
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

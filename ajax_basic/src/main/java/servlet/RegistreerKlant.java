package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Adres;
import bean.Contact;
import bean.Klant;
import dao.AdresDAO;
import dao.ContactDAO;
import dao.DAOFactory;
import dao.KlantDAO;

@WebServlet("/registreerKlant")
public class RegistreerKlant extends HttpServlet {
	private KlantDAO klantdao = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getKlantDAO();
	private AdresDAO adresdao = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getAdresDAO();
	private ContactDAO contactdao = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getContactDAO();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		String naam = request.getParameter("klantNaam");
		String btw = request.getParameter("klantBtw");
		String straat = request.getParameter("klantStraat");
		String nr = request.getParameter("klantNr");
		String postcode = request.getParameter("klantPostcode");
		String woonplaats = request.getParameter("klantWoonplaats");
		String land = request.getParameter("klantLand");
		String telefoonnr = request.getParameter("klantTelefoonnr");
		String email = request.getParameter("klantEmail");

		if (!parametersNotEmpty(naam, straat, nr, postcode, woonplaats, land, telefoonnr, email)) {
			out.print("<i>niet alle gegevens ingevuld</i>");
		} else {
			Adres adres = new Adres();
			adres.setStraat(straat);
			adres.setNr(nr);
			adres.setPostcode(postcode);
			adres.setWoonplaats(woonplaats);
			adres.setLand(land);
			adres.setId(adresdao.insertAdres(adres));

			Klant klant = new Klant();
			klant.setNaam(naam);
			klant.setBtw(btw);
			klant.setFacturatieadres(adres);
			klant.setAfleveradres(adres);
			klant.setId(klantdao.insertKlant(klant));

			Contact contact = new Contact();
			contact.setContactType(Contact.ContactType.VAST);
			contact.setContact(telefoonnr);
			contact.setKlant(klant);
			contact.setId(contactdao.insertContact(contact));

			contact = new Contact();
			contact.setContactType(Contact.ContactType.EMAIL);
			contact.setContact(email);
			contact.setKlant(klant);
			contact.setId(contactdao.insertContact(contact));

			out.print("Klant toegevoegd");

		}
	}

	private boolean parametersNotEmpty(String... parameters) {
		for (String parameter : parameters) {
			if ((parameter == null) || (parameter.trim().equals(""))) {
				return false;
			}
		}
		return true;
	}
}

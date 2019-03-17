package projekcije.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projekcije.beans.Film;
import projekcije.dao.FilmDAO;
import projekcije.dao.ProjekcijaDAO;

/**
 * Servlet implementation class Baza
 */
public class Baza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Baza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String film = request.getParameter("film");
		String vreme = request.getParameter("vreme");
		String cena = request.getParameter("cena");
		String sala = request.getParameter("sala");
		String duzina = request.getParameter("duzina");
		String tip = request.getParameter("tip");
		
		FilmDAO fil = new FilmDAO();
		Film filmObj = fil.getByNaziv(film);
		
		ProjekcijaDAO pr = new ProjekcijaDAO();
		pr.add(filmObj.getId(), vreme, Integer.parseInt(cena),Integer.parseInt(sala),Integer.parseInt(duzina), tip);
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h1>Informacije o unosu:</h1>");
		pw.println("<p>Film: " + film + "</p>");
		pw.println("<p>Vreme: " + vreme+ "</p>");
		pw.println("<p>Cena: " + cena + "</p>");
		pw.println("<p>Sala: " + sala + "</p>");
		pw.println("<p>Duzina projekcije: " + duzina + "</p>");
		pw.println("<p>Tip projekcije: " + tip + "</p>");
		
		pw.println("</body>");
		pw.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package projekcije.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projekcije.beans.Film;
import projekcije.beans.Projekcija;

/**
 * Servlet implementation class DodavanjeProjekcije
 */
public class DodavanjeProjekcije extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodavanjeProjekcije() {
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
		ArrayList<Projekcija> projekcije = (ArrayList<Projekcija>)getServletContext().getAttribute("projekcije");
		Projekcija p = new Projekcija(0, new Film(0,film), vreme, Integer.parseInt(cena),Integer.parseInt(duzina),Integer.parseInt(sala), tip);
		projekcije.add(p);
		
		
		System.out.println("Podaci o projekciji");
		System.out.println("-------------------");
		
			System.out.println("Film se zove " + film + ", i odrzava se u " + vreme + "h. Cena projekcije je " + cena + " dinara i projekcija je u " + tip + " formatu. Projekcija se prikazuje  u sali " + sala + " i traje " + duzina + " minuta." );
		
		
		
		
		if (tip.equalsIgnoreCase("3D")) {
			response.sendRedirect("3d.jsp");
		}else {
			response.sendRedirect("TabelerniPrikaz");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

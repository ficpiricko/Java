package projekcije.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projekcije.beans.Film;
import projekcije.beans.Projekcija;

/**
 * Servlet implementation class TabelerniPrikaz
 */
public class TabelerniPrikaz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TabelerniPrikaz() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		 ArrayList<Projekcija> projekcije = new ArrayList<Projekcija>();  
		 projekcije.add(new Projekcija(0, new Film(0,"The Lord of the Rings: The Fellowship of the Ring"), "20:20", 350, 180, 1, "2D"));
		 projekcije.add(new Projekcija(0, new Film(0,"The Lord of the Rings: The Two Towers"), "20:00", 350, 240, 2, "2D"));
		 projekcije.add(new Projekcija(0, new Film(0,"The Lord of the Rings: The Return of the King"), "21:00", 350,200, 3, "3D"));
		 getServletContext().setAttribute("projekcije", projekcije);
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Projekcija> projekcije = (ArrayList<Projekcija>)getServletContext().getAttribute("projekcije");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<p> Projekcije </p> ");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<th>Film</th>");
		pw.println("<th>Vreme</th>");
		pw.println("<th>Cena</th>");
		pw.println("<th>Duzina</th>");
		pw.println("<th>Sala</th>");
		pw.println("<th>Tip</th>");
		for (int i=0;i<projekcije.size();i++) {
			
			pw.println("<tr>");
			
			pw.println("<td>"+projekcije.get(i).getFilm().getNaziv() +"</td>");
			pw.println("<td>"+projekcije.get(i).getVreme()+"</td>");
			pw.println("<td>"+projekcije.get(i).getCena()+"</td>");
			pw.println("<td>"+projekcije.get(i).getDuzina()+"</td>");
			pw.println("<td>"+projekcije.get(i).getBrojSale()+"</td>");
			pw.println("<td>"+projekcije.get(i).getTip()+"</td>");
			pw.println("</tr>");
		}
		pw.println("</tr>");
		pw.println("</table>");
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

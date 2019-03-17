package projekcije.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.mysql.cj.protocol.Resultset;

import projekcije.beans.Film;
import projekcije.util.ConnectionManager;

public class FilmDAO {
	public Film getByNaziv (String naziv) {
		Film film = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query ="SELECT id FROM film WHERE naziv=?";
			pstmt = ConnectionManager.getConnection().prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, naziv);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				index = 1;
				int id = rset.getInt(index++);
				film = new Film (id,naziv);
			}
			rset.close();
			pstmt.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return film;
		
	}
	public Film getById (int id) {
		Film film = null;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			String query ="SELECT naziv FROM film WHERE id=" + id;
			
			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(query);
			
			if (rset.next()) {
				int index = 1;
				String naziv = rset.getString(index++);
				film = new Film(id,naziv);
			}
		}catch (SQLException ex){
			
			System.out.println("Greska u SQL upitu.");
			ex.printStackTrace();
	}finally {
		try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
	}
	return film;
}
}

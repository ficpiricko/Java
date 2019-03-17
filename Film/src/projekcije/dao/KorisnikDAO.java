package projekcije.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import projekcije.beans.Korisnik;
import projekcije.util.ConnectionManager;

public class KorisnikDAO {

	public Korisnik getKorisnikByUsernameAndPassword (String username, String password) {
		Korisnik korisnik = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query = "SELECT id  FROM User WHERE username=? AND password=?";
			pstmt = ConnectionManager.getConnection().prepareStatement(query);
			int index =1;
			pstmt.setString(index++, username);
			pstmt.setString(index++, password);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				index = 1;
				int id = rset.getInt(index);
				korisnik = new Korisnik(id, username, password);
			}
			rset.close();
			pstmt.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return korisnik;
	}
}

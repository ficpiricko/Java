package projekcije.dao;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import projekcije.beans.Film;
import projekcije.beans.Projekcija;
import projekcije.util.ConnectionManager;


public class ProjekcijaDAO {
	public static List<Projekcija> getAll () {
		List<Projekcija> projekcije = new ArrayList<Projekcija>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			String query = "SELECT * FROM projekcija";
			
			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				int index = 1;
				String vreme = rset.getString(index++);
				int cena = rset.getInt(index++);
				int duzina = rset.getInt(index++);
				int brojSale = rset.getInt(index++);
				String tip = rset.getString(index++);
				int filmId = rset.getInt(index++);
				
				Film film = new Film (filmId);
				Projekcija pr = new Projekcija(0,film,vreme,cena,duzina,brojSale,tip);
				projekcije.add(pr);
			}
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally{
				try {
					stmt.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
				try {
					rset.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		return projekcije;
	}
	public boolean add (int film ,String vreme, int cena,int sala,int duzina,String tip) {
		boolean retVal = false;
		try {
			String query = "INSERT INTO projekcija (film ,vreme,cena,duzina,brojSale,tip)VALUES (?, ?, ?,?,?,?) ";
			PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(query);
			pstmt.setInt(1, film);
			pstmt.setString(2, vreme);
			pstmt.setInt(3, cena);
			pstmt.setInt(4, sala);
			pstmt.setInt(5, duzina);
			pstmt.setString(6, tip);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
		}
	}


package projekcije.beans;

public class Projekcija {
	
	private int id;
	private Film film;
	private String vreme;
	private int cena;
	private int duzina;
	private int brojSale;
	private String tip;
	public Projekcija(int id, Film film, String vreme, int cena, int duzina,
			int brojSale, String tip) {
		super();
		this.id = id;
		this.film = film;
		this.vreme = vreme;
		this.cena = cena;
		this.duzina = duzina;
		this.brojSale = brojSale;
		this.tip = tip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public int getDuzina() {
		return duzina;
	}
	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}
	public int getBrojSale() {
		return brojSale;
	}
	public void setBrojSale(int brojSale) {
		this.brojSale = brojSale;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
}

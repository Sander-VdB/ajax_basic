package be.groept;

public class Klant {

	private int id;
	private String naam;
	private String btw;
	private String straat;
	private String nr;
	private String postcode;
	private String woonplaats;
	private String land;
	private String telefoonnr;
	private String email;

	public Klant() {
	}

	public Klant(String naam) {
		this.setNaam(naam);
		this.setBtw("");
		this.setStraat("");
		this.setNr("");
		this.setPostcode("");
		this.setWoonplaats("");
		this.setLand("");
		this.setTelefoonnr("");
		this.setEmail("");
	}

	public Klant(String naam, String btw, String straat, String nr, String postcode, String woonplaats, String land, String tel,
			String email) {
		this.setNaam(naam);
		this.setBtw(btw);
		this.setStraat(straat);
		this.setNr(nr);
		this.setPostcode(postcode);
		this.setWoonplaats(woonplaats);
		this.setLand(land);
		this.setTelefoonnr(tel);
		this.setEmail(email);
	}

	public Klant(int id, String naam, String btw, String straat, String nr, String postcode, String woonplaats, String land,
			String tel, String email) {
		this.setId(id);
		this.setNaam(naam);
		this.setBtw(btw);
		this.setStraat(straat);
		this.setNr(nr);
		this.setPostcode(postcode);
		this.setWoonplaats(woonplaats);
		this.setLand(land);
		this.setTelefoonnr(tel);
		this.setEmail(email);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getBtw() {
		return btw;
	}

	public void setBtw(String btw) {
		this.btw = btw;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getTelefoonnr() {
		return telefoonnr;
	}

	public void setTelefoonnr(String telefoonnr) {
		this.telefoonnr = telefoonnr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Klant) {
			Klant klantobject = (Klant) object;
			if (klantobject.getId() == this.getId() && klantobject.getNaam().equals(this.getNaam())
					&& klantobject.getBtw().equals(this.getBtw())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}

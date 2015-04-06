package bean;

public class Klant {

	private int id;
	private String naam;
	private String btw;
	private String telefoonnr;
	private String email;
	private Adres facturatieadres;
	private Adres afleveradres;

	public Klant() {
		this.setId(-1);
		this.facturatieadres = new Adres();
		this.afleveradres = new Adres();
	}

	public Klant(String naam) {
		this.setId(-1);
		this.setFacturatieadres(new Adres());
		this.setAfleveradres(new Adres());
		this.setNaam(naam);
	}

	public Klant(Klant _klant) {
		this.setNaam(_klant.getNaam());
		this.setBtw(_klant.getBtw());
		this.setId(-1);
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

	public Adres getFacturatieadres() {
		return facturatieadres;
	}

	public void setFacturatieadres(Adres facturatieadresId) {
		this.facturatieadres = facturatieadresId;
	}

	public Adres getAfleveradres() {
		return afleveradres;
	}

	public void setAfleveradres(Adres afleveradresId) {
		this.afleveradres = afleveradresId;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Klant) {
			Klant klantobject = (Klant) object;
			if (klantobject.getNaam().equals(this.getNaam()) && klantobject.getBtw().equals(this.getBtw())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}

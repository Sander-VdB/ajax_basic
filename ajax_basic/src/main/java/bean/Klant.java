package bean;

public class Klant {

	private int id;
	private String naam;
	private String btw;
	private String telefoonnr;
	private String email;

	public Klant() {
		this.setId(-1);
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

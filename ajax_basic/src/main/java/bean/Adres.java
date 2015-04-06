package bean;

public class Adres {

	private int id;
	private String straat;
	private String nr;
	private String postcode;
	private String woonplaats;
	private String land;
	private boolean actief;

	public Adres() {
		this.setId(-1);
	}

	public Adres(Adres _adres) {
		this.setId(-1);
		this.setStraat(_adres.getStraat());
		this.setNr(_adres.getNr());
		this.setPostcode(_adres.getPostcode());
		this.setWoonplaats(_adres.getWoonplaats());
		this.setLand(_adres.getLand());
		this.setActief(_adres.isActief());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isActief() {
		return actief;
	}

	public void setActief(boolean actief) {
		this.actief = actief;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Adres) {
			Adres classobject = (Adres) object;

			return (classobject.getLand().equals(this.getLand()) && classobject.getNr().equals(this.getNr())
					&& classobject.getPostcode().equals(this.getPostcode()) && classobject.getStraat().equals(this.getStraat())
					&& classobject.getWoonplaats().equals(this.getWoonplaats()) && classobject.isActief() == this.isActief());
		} else {
			return false;
		}
	}
}

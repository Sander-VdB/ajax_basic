package bean;

import java.util.Date;

public class Opdracht {

	private int id;
	private Klant klant;
	private String korteOmschrijving;
	private String omschrijving;
	private Date geopend;
	private Date afgesloten;
	private String beheerder;

	public Opdracht() {
		this.setId(-1);
		this.setKlant(new Klant());
		this.setGeopend(new Date());
	}

	public Opdracht(String korteOmschrijving, String omschrijving, String beheerder) {
		this();
		this.setKorteOmschrijving(korteOmschrijving);
		this.setOmschrijving(omschrijving);
		this.setBeheerder(beheerder);
	}

	public Opdracht(Opdracht _opdracht) {
		this(_opdracht.getKorteOmschrijving(), _opdracht.getOmschrijving(), _opdracht.getBeheerder());
		this.setId(_opdracht.getId());
		this.setGeopend(_opdracht.getGeopend());
		this.setAfgesloten(_opdracht.getAfgesloten());
		this.setKlant(_opdracht.getKlant());
	}

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	public String getKorteOmschrijving() {
		return korteOmschrijving;
	}

	public void setKorteOmschrijving(String korteOmschrijving) {
		this.korteOmschrijving = korteOmschrijving;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public Date getGeopend() {
		return geopend;
	}

	public void setGeopend(Date geopend) {
		this.geopend = geopend;
	}

	public Date getAfgesloten() {
		return afgesloten;
	}

	public void setAfgesloten(Date afgesloten) {
		this.afgesloten = afgesloten;
	}

	public String getBeheerder() {
		return beheerder;
	}

	public void setBeheerder(String beheerder) {
		this.beheerder = beheerder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Opdracht) {
			Opdracht klantobject = (Opdracht) object;
			if (klantobject.getKorteOmschrijving().equals(this.getKorteOmschrijving())
					&& klantobject.getOmschrijving().equals(this.getOmschrijving())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}

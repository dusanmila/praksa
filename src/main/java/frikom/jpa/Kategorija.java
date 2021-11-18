package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kategorija database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorija.findAll", query="SELECT k FROM Kategorija k")
public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KATEGORIJA_IDKATEGORIJA_GENERATOR", sequenceName="KATEGORIJA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KATEGORIJA_IDKATEGORIJA_GENERATOR")
	@Column(name="id_kategorija")
	private Integer idKategorija;

	private String kategorija;

	private String potkategorija;

	public Kategorija() {
	}

	public Integer getIdKategorija() {
		return this.idKategorija;
	}

	public void setIdKategorija(Integer idKategorija) {
		this.idKategorija = idKategorija;
	}

	public String getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getPotkategorija() {
		return this.potkategorija;
	}

	public void setPotkategorija(String potkategorija) {
		this.potkategorija = potkategorija;
	}

}
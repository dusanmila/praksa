package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dnevni database table.
 * 
 */
@Entity
@NamedQuery(name="Dnevni.findAll", query="SELECT d FROM Dnevni d")
public class Dnevni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DNEVNI_IDDNEVNI_GENERATOR", sequenceName="DNEVNI_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DNEVNI_IDDNEVNI_GENERATOR")
	@Column(name="id_dnevni")
	private Integer idDnevni;

	@Column(name="povracaj_dobavljac")
	private Integer povracajDobavljac;

	@Column(name="povracaj_magacin")
	private Integer povracajMagacin;

	private Integer prodaja;

	@Column(name="ulaz_dobavljac")
	private Integer ulazDobavljac;

	@Column(name="ulaz_magacin")
	private Integer ulazMagacin;

	//bi-directional many-to-one association to Artikl
	@ManyToOne
	@JoinColumn(name="id_artikl")
	private Artikl artikl;

	//bi-directional many-to-one association to Datum
	@ManyToOne
	@JoinColumn(name="id_datum")
	private Datum datum;

	//bi-directional many-to-one association to Objekat
	@ManyToOne
	@JoinColumn(name="id_objekat")
	private Objekat objekat;

	public Dnevni() {
	}

	public Integer getIdDnevni() {
		return this.idDnevni;
	}

	public void setIdDnevni(Integer idDnevni) {
		this.idDnevni = idDnevni;
	}

	public Integer getPovracajDobavljac() {
		return this.povracajDobavljac;
	}

	public void setPovracajDobavljac(Integer povracajDobavljac) {
		this.povracajDobavljac = povracajDobavljac;
	}

	public Integer getPovracajMagacin() {
		return this.povracajMagacin;
	}

	public void setPovracajMagacin(Integer povracajMagacin) {
		this.povracajMagacin = povracajMagacin;
	}

	public Integer getProdaja() {
		return this.prodaja;
	}

	public void setProdaja(Integer prodaja) {
		this.prodaja = prodaja;
	}

	public Integer getUlazDobavljac() {
		return this.ulazDobavljac;
	}

	public void setUlazDobavljac(Integer ulazDobavljac) {
		this.ulazDobavljac = ulazDobavljac;
	}

	public Integer getUlazMagacin() {
		return this.ulazMagacin;
	}

	public void setUlazMagacin(Integer ulazMagacin) {
		this.ulazMagacin = ulazMagacin;
	}

	public Artikl getArtikl() {
		return this.artikl;
	}

	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}

	public Datum getDatum() {
		return this.datum;
	}

	public void setDatum(Datum datum) {
		this.datum = datum;
	}

	public Objekat getObjekat() {
		return this.objekat;
	}

	public void setObjekat(Objekat objekat) {
		this.objekat = objekat;
	}

}
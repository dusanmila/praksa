package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the istor_dne database table.
 * 
 */
@Entity
@Table(name="istor_dne")
@NamedQuery(name="IstorDne.findAll", query="SELECT i FROM IstorDne i")
public class IstorDne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ISTOR_DNE_IDISTORDNE_GENERATOR", sequenceName="ISTOR_DNE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ISTOR_DNE_IDISTORDNE_GENERATOR")
	@Column(name="id_istor_dne")
	private Integer idIstorDne;

	@Column(name="povracaj_dobavljac")
	private Integer povracajDobavljac;

	@Column(name="povracaj_magacin")
	private Integer povracajMagacin;

	private Integer prodaja;

	@Column(name="ulaz_dobavljac")
	private Integer ulazDobavljac;

	@Column(name="ulaz_magacin")
	private Integer ulazMagacin;

	//bi-directional many-to-one association to Datum
	@ManyToOne
	@JoinColumn(name="id_datum")
	private Datum datum;

	//bi-directional many-to-one association to Artikl
	@ManyToOne
	@JoinColumn(name="id_artikl")
	private Artikl artikl;

	//bi-directional many-to-one association to Objekat
	@ManyToOne
	@JoinColumn(name="id_objekat")
	private Objekat objekat;

	public IstorDne() {
	}

	public Integer getIdIstorDne() {
		return this.idIstorDne;
	}

	public void setIdIstorDne(Integer idIstorDne) {
		this.idIstorDne = idIstorDne;
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

	public Datum getDatum() {
		return this.datum;
	}

	public void setDatum(Datum datum) {
		this.datum = datum;
	}

	public Artikl getArtikl() {
		return this.artikl;
	}

	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}

	public Objekat getObjekat() {
		return this.objekat;
	}

	public void setObjekat(Objekat objekat) {
		this.objekat = objekat;
	}

}
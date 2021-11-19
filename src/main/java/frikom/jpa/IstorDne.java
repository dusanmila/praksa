package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the istor_dne database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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

	@Column(name="id_artikl")
	private Integer idArtikl;

	@Column(name="id_datum")
	private Integer idDatum;

	@Column(name="id_objekat")
	private Integer idObjekat;

	@Column(name="povracaj_dobavljac")
	private Integer povracajDobavljac;

	@Column(name="povracaj_magacin")
	private Integer povracajMagacin;

	private Integer prodaja;

	@Column(name="ulaz_dobavljac")
	private Integer ulazDobavljac;

	@Column(name="ulaz_magacin")
	private Integer ulazMagacin;

	public IstorDne() {
	}

	public Integer getIdIstorDne() {
		return this.idIstorDne;
	}

	public void setIdIstorDne(Integer idIstorDne) {
		this.idIstorDne = idIstorDne;
	}

	public Integer getIdArtikl() {
		return this.idArtikl;
	}

	public void setIdArtikl(Integer idArtikl) {
		this.idArtikl = idArtikl;
	}

	public Integer getIdDatum() {
		return this.idDatum;
	}

	public void setIdDatum(Integer idDatum) {
		this.idDatum = idDatum;
	}

	public Integer getIdObjekat() {
		return this.idObjekat;
	}

	public void setIdObjekat(Integer idObjekat) {
		this.idObjekat = idObjekat;
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

}
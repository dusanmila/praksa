package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the istor_ned database table.
 * 
 */
@Entity
@Table(name="istor_ned")
@NamedQuery(name="IstorNed.findAll", query="SELECT i FROM IstorNed i")
public class IstorNed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ISTOR_NED_IDISTORNED_GENERATOR", sequenceName="ISTOR_NED_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ISTOR_NED_IDISTORNED_GENERATOR")
	@Column(name="id_istor_ned")
	private Integer idIstorNed;

	@Column(name="id_artikl")
	private Integer idArtikl;

	@Column(name="id_datum_do")
	private Integer idDatumDo;

	@Column(name="id_datum_od")
	private Integer idDatumOd;

	@Column(name="id_objekat")
	private Integer idObjekat;

	private Integer prodaja;

	public IstorNed() {
	}

	public Integer getIdIstorNed() {
		return this.idIstorNed;
	}

	public void setIdIstorNed(Integer idIstorNed) {
		this.idIstorNed = idIstorNed;
	}

	public Integer getIdArtikl() {
		return this.idArtikl;
	}

	public void setIdArtikl(Integer idArtikl) {
		this.idArtikl = idArtikl;
	}

	public Integer getIdDatumDo() {
		return this.idDatumDo;
	}

	public void setIdDatumDo(Integer idDatumDo) {
		this.idDatumDo = idDatumDo;
	}

	public Integer getIdDatumOd() {
		return this.idDatumOd;
	}

	public void setIdDatumOd(Integer idDatumOd) {
		this.idDatumOd = idDatumOd;
	}

	public Integer getIdObjekat() {
		return this.idObjekat;
	}

	public void setIdObjekat(Integer idObjekat) {
		this.idObjekat = idObjekat;
	}

	public Integer getProdaja() {
		return this.prodaja;
	}

	public void setProdaja(Integer prodaja) {
		this.prodaja = prodaja;
	}

}
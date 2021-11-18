package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the istor_mes database table.
 * 
 */
@Entity
@Table(name="istor_mes")
@NamedQuery(name="IstorMes.findAll", query="SELECT i FROM IstorMes i")
public class IstorMes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ISTOR_MES_IDISTORMES_GENERATOR", sequenceName="ISTOR_MES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ISTOR_MES_IDISTORMES_GENERATOR")
	@Column(name="id_istor_mes")
	private Integer idIstorMes;

	@Column(name="id_artikl")
	private Integer idArtikl;

	@Column(name="id_datum_do")
	private Integer idDatumDo;

	@Column(name="id_datum_od")
	private Integer idDatumOd;

	@Column(name="id_objekat")
	private Integer idObjekat;

	private Integer prodaja;

	public IstorMes() {
	}

	public Integer getIdIstorMes() {
		return this.idIstorMes;
	}

	public void setIdIstorMes(Integer idIstorMes) {
		this.idIstorMes = idIstorMes;
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
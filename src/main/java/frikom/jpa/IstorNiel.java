package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the istor_niel database table.
 * 
 */
@Entity
@Table(name="istor_niel")
@NamedQuery(name="IstorNiel.findAll", query="SELECT i FROM IstorNiel i")
public class IstorNiel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ISTOR_NIEL_IDISTORNIEL_GENERATOR", sequenceName="ISTOR_NIEL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ISTOR_NIEL_IDISTORNIEL_GENERATOR")
	@Column(name="id_istor_niel")
	private Integer idIstorNiel;

	@Column(name="id_artikl")
	private Integer idArtikl;

	@Column(name="id_datum_do")
	private Integer idDatumDo;

	@Column(name="id_datum_od")
	private Integer idDatumOd;

	private Integer prodaja;

	public IstorNiel() {
	}

	public Integer getIdIstorNiel() {
		return this.idIstorNiel;
	}

	public void setIdIstorNiel(Integer idIstorNiel) {
		this.idIstorNiel = idIstorNiel;
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

	public Integer getProdaja() {
		return this.prodaja;
	}

	public void setProdaja(Integer prodaja) {
		this.prodaja = prodaja;
	}

}
package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mesecni database table.
 * 
 */
@Entity
@NamedQuery(name="Mesecni.findAll", query="SELECT m FROM Mesecni m")
public class Mesecni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESECNI_IDMESECNI_GENERATOR", sequenceName="MESECNI_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESECNI_IDMESECNI_GENERATOR")
	@Column(name="id_mesecni")
	private Integer idMesecni;

	@Column(name="id_artikl")
	private Integer idArtikl;

	@Column(name="id_datum_do")
	private Integer idDatumDo;

	@Column(name="id_datum_od")
	private Integer idDatumOd;

	private Integer prodaja;

	//bi-directional many-to-one association to Objekat
	@ManyToOne
	@JoinColumn(name="id_objekat")
	private Objekat objekat;

	public Mesecni() {
	}

	public Integer getIdMesecni() {
		return this.idMesecni;
	}

	public void setIdMesecni(Integer idMesecni) {
		this.idMesecni = idMesecni;
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

	public Objekat getObjekat() {
		return this.objekat;
	}

	public void setObjekat(Objekat objekat) {
		this.objekat = objekat;
	}

}
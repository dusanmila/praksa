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

	private Integer prodaja;

	//bi-directional many-to-one association to Datum
	@ManyToOne
	@JoinColumn(name="id_datum_do")
	private Datum datum1;

	//bi-directional many-to-one association to Datum
	@ManyToOne
	@JoinColumn(name="id_datum_od")
	private Datum datum2;

	//bi-directional many-to-one association to Artikl
	@ManyToOne
	@JoinColumn(name="id_artikl")
	private Artikl artikl;

	//bi-directional many-to-one association to Objekat
	@ManyToOne
	@JoinColumn(name="id_objekat")
	private Objekat objekat;

	public IstorMes() {
	}

	public Integer getIdIstorMes() {
		return this.idIstorMes;
	}

	public void setIdIstorMes(Integer idIstorMes) {
		this.idIstorMes = idIstorMes;
	}

	public Integer getProdaja() {
		return this.prodaja;
	}

	public void setProdaja(Integer prodaja) {
		this.prodaja = prodaja;
	}

	public Datum getDatum1() {
		return this.datum1;
	}

	public void setDatum1(Datum datum1) {
		this.datum1 = datum1;
	}

	public Datum getDatum2() {
		return this.datum2;
	}

	public void setDatum2(Datum datum2) {
		this.datum2 = datum2;
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
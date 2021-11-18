package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nielsen database table.
 * 
 */
@Entity
@NamedQuery(name="Nielsen.findAll", query="SELECT n FROM Nielsen n")
public class Nielsen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NIELSEN_IDNIELSEN_GENERATOR", sequenceName="NIELSEN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NIELSEN_IDNIELSEN_GENERATOR")
	@Column(name="id_nielsen")
	private Integer idNielsen;

	private Integer prodaja;

	//bi-directional many-to-one association to Artikl
	@ManyToOne
	@JoinColumn(name="id_artikl")
	private Artikl artikl;

	//bi-directional many-to-one association to Datum
	@ManyToOne
	@JoinColumn(name="id_datum_do")
	private Datum datum1;

	//bi-directional many-to-one association to Datum
	@ManyToOne
	@JoinColumn(name="id_datum_od")
	private Datum datum2;

	//bi-directional many-to-one association to Objekat
	@ManyToOne
	@JoinColumn(name="id_objekat")
	private Objekat objekat;

	public Nielsen() {
	}

	public Integer getIdNielsen() {
		return this.idNielsen;
	}

	public void setIdNielsen(Integer idNielsen) {
		this.idNielsen = idNielsen;
	}

	public Integer getProdaja() {
		return this.prodaja;
	}

	public void setProdaja(Integer prodaja) {
		this.prodaja = prodaja;
	}

	public Artikl getArtikl() {
		return this.artikl;
	}

	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
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

	public Objekat getObjekat() {
		return this.objekat;
	}

	public void setObjekat(Objekat objekat) {
		this.objekat = objekat;
	}

}
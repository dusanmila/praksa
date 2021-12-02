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

	public IstorNiel() {
	}

	public Integer getIdIstorNiel() {
		return this.idIstorNiel;
	}

	public void setIdIstorNiel(Integer idIstorNiel) {
		this.idIstorNiel = idIstorNiel;
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

}
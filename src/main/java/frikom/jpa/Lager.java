package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lager database table.
 * 
 */
@Entity
@NamedQuery(name="Lager.findAll", query="SELECT l FROM Lager l")
public class Lager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LAGER_IDLAGER_GENERATOR", sequenceName="LAGER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LAGER_IDLAGER_GENERATOR")
	@Column(name="id_lager")
	private Integer idLager;

	private Integer stanje;

	//bi-directional many-to-one association to Artikl
	@ManyToOne
	@JoinColumn(name="id_artikl")
	private Artikl artikl;

	//bi-directional many-to-one association to Objekat
	@ManyToOne
	@JoinColumn(name="id_objekat")
	private Objekat objekat;

	public Lager() {
	}

	public Integer getIdLager() {
		return this.idLager;
	}

	public void setIdLager(Integer idLager) {
		this.idLager = idLager;
	}

	public Integer getStanje() {
		return this.stanje;
	}

	public void setStanje(Integer stanje) {
		this.stanje = stanje;
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
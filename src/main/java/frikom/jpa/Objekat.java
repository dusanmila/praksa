package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the objekat database table.
 * 
 */
@Entity
@NamedQuery(name="Objekat.findAll", query="SELECT o FROM Objekat o")
public class Objekat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBJEKAT_IDOBJEKAT_GENERATOR", sequenceName="OBJEKAT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBJEKAT_IDOBJEKAT_GENERATOR")
	@Column(name="id_objekat")
	private Integer idObjekat;

	private String adresa;

	private String format;

	@Column(name="naziv_objekta")
	private String nazivObjekta;

	private String regija;

	private String status;

	//bi-directional many-to-one association to Mesecni
	@OneToMany(mappedBy="objekat")
	private List<Mesecni> mesecnis;

	//bi-directional many-to-one association to KategObj
	@ManyToOne
	@JoinColumn(name="id_kateg_obj")
	private KategObj kategObj;

	//bi-directional many-to-one association to Lanac
	@ManyToOne
	@JoinColumn(name="id_lanac")
	private Lanac lanac;

	//bi-directional many-to-one association to Mesto
	@ManyToOne
	@JoinColumn(name="id_mesto")
	private Mesto mesto;

	public Objekat() {
	}

	public Integer getIdObjekat() {
		return this.idObjekat;
	}

	public void setIdObjekat(Integer idObjekat) {
		this.idObjekat = idObjekat;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getNazivObjekta() {
		return this.nazivObjekta;
	}

	public void setNazivObjekta(String nazivObjekta) {
		this.nazivObjekta = nazivObjekta;
	}

	public String getRegija() {
		return this.regija;
	}

	public void setRegija(String regija) {
		this.regija = regija;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Mesecni> getMesecnis() {
		return this.mesecnis;
	}

	public void setMesecnis(List<Mesecni> mesecnis) {
		this.mesecnis = mesecnis;
	}

	public Mesecni addMesecni(Mesecni mesecni) {
		getMesecnis().add(mesecni);
		mesecni.setObjekat(this);

		return mesecni;
	}

	public Mesecni removeMesecni(Mesecni mesecni) {
		getMesecnis().remove(mesecni);
		mesecni.setObjekat(null);

		return mesecni;
	}

	public KategObj getKategObj() {
		return this.kategObj;
	}

	public void setKategObj(KategObj kategObj) {
		this.kategObj = kategObj;
	}

	public Lanac getLanac() {
		return this.lanac;
	}

	public void setLanac(Lanac lanac) {
		this.lanac = lanac;
	}

	public Mesto getMesto() {
		return this.mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

}
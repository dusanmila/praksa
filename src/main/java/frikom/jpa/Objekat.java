package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the objekat database table.
 * 
 */

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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
	@JsonIgnore
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

	//bi-directional many-to-one association to Dnevni
	@JsonIgnore
	@OneToMany(mappedBy="objekat")
	private List<Dnevni> dnevnis;

	//bi-directional many-to-one association to Lager
	@JsonIgnore
	@OneToMany(mappedBy="objekat")
	private List<Lager> lagers;

	//bi-directional many-to-one association to Nedeljni
	@JsonIgnore
	@OneToMany(mappedBy="objekat")
	private List<Nedeljni> nedeljnis;

	//bi-directional many-to-one association to Nielsen
	@JsonIgnore
	@OneToMany(mappedBy="objekat")
	private List<Nielsen> nielsens;

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

	public List<Dnevni> getDnevnis() {
		return this.dnevnis;
	}

	public void setDnevnis(List<Dnevni> dnevnis) {
		this.dnevnis = dnevnis;
	}

	public Dnevni addDnevni(Dnevni dnevni) {
		getDnevnis().add(dnevni);
		dnevni.setObjekat(this);

		return dnevni;
	}

	public Dnevni removeDnevni(Dnevni dnevni) {
		getDnevnis().remove(dnevni);
		dnevni.setObjekat(null);

		return dnevni;
	}

	public List<Lager> getLagers() {
		return this.lagers;
	}

	public void setLagers(List<Lager> lagers) {
		this.lagers = lagers;
	}

	public Lager addLager(Lager lager) {
		getLagers().add(lager);
		lager.setObjekat(this);

		return lager;
	}

	public Lager removeLager(Lager lager) {
		getLagers().remove(lager);
		lager.setObjekat(null);

		return lager;
	}

	public List<Nedeljni> getNedeljnis() {
		return this.nedeljnis;
	}

	public void setNedeljnis(List<Nedeljni> nedeljnis) {
		this.nedeljnis = nedeljnis;
	}

	public Nedeljni addNedeljni(Nedeljni nedeljni) {
		getNedeljnis().add(nedeljni);
		nedeljni.setObjekat(this);

		return nedeljni;
	}

	public Nedeljni removeNedeljni(Nedeljni nedeljni) {
		getNedeljnis().remove(nedeljni);
		nedeljni.setObjekat(null);

		return nedeljni;
	}

	public List<Nielsen> getNielsens() {
		return this.nielsens;
	}

	public void setNielsens(List<Nielsen> nielsens) {
		this.nielsens = nielsens;
	}

	public Nielsen addNielsen(Nielsen nielsen) {
		getNielsens().add(nielsen);
		nielsen.setObjekat(this);

		return nielsen;
	}

	public Nielsen removeNielsen(Nielsen nielsen) {
		getNielsens().remove(nielsen);
		nielsen.setObjekat(null);

		return nielsen;
	}

}
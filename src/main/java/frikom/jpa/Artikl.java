package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the artikl database table.
 * 
 */
@Entity
@NamedQuery(name="Artikl.findAll", query="SELECT a FROM Artikl a")
public class Artikl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARTIKL_IDARTIKL_GENERATOR", sequenceName="ARTIKL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARTIKL_IDARTIKL_GENERATOR")
	@Column(name="id_artikl")
	private Integer idArtikl;

	@Column(name="cena_bezpdv")
	private BigDecimal cenaBezpdv;

	@Column(name="cena_pdv")
	private BigDecimal cenaPdv;

	@Column(name="eon_kod")
	private String eonKod;

	@Column(name="komercijalno_pakovanje")
	private Integer komercijalnoPakovanje;

	@Column(name="maloprodajna_cena")
	private BigDecimal maloprodajnaCena;

	private String naziv;

	private BigDecimal promena;

	private Integer rok;

	@Column(name="transportni_bar_kod")
	private String transportniBarKod;

	@Column(name="transportnih_pakovanja")
	private Integer transportnihPakovanja;

	private BigDecimal zapremina;

	//bi-directional many-to-one association to JedMere
	@ManyToOne
	@JoinColumn(name="id_jed_mere")
	private JedMere jedMere;

	//bi-directional many-to-one association to VrstaAmbal
	@ManyToOne
	@JoinColumn(name="id_vrsta_ambalaze")
	private VrstaAmbal vrstaAmbal;

	//bi-directional many-to-one association to Dnevni
	@OneToMany(mappedBy="artikl")
	private List<Dnevni> dnevnis;

	//bi-directional many-to-one association to Lager
	@OneToMany(mappedBy="artikl")
	private List<Lager> lagers;

	//bi-directional many-to-one association to Mesecni
	@OneToMany(mappedBy="artikl")
	private List<Mesecni> mesecnis;

	//bi-directional many-to-one association to Nedeljni
	@OneToMany(mappedBy="artikl")
	private List<Nedeljni> nedeljnis;

	//bi-directional many-to-one association to Nielsen
	@OneToMany(mappedBy="artikl")
	private List<Nielsen> nielsens;

	public Artikl() {
	}

	public Integer getIdArtikl() {
		return this.idArtikl;
	}

	public void setIdArtikl(Integer idArtikl) {
		this.idArtikl = idArtikl;
	}

	public BigDecimal getCenaBezpdv() {
		return this.cenaBezpdv;
	}

	public void setCenaBezpdv(BigDecimal cenaBezpdv) {
		this.cenaBezpdv = cenaBezpdv;
	}

	public BigDecimal getCenaPdv() {
		return this.cenaPdv;
	}

	public void setCenaPdv(BigDecimal cenaPdv) {
		this.cenaPdv = cenaPdv;
	}

	public String getEonKod() {
		return this.eonKod;
	}

	public void setEonKod(String eonKod) {
		this.eonKod = eonKod;
	}

	public Integer getKomercijalnoPakovanje() {
		return this.komercijalnoPakovanje;
	}

	public void setKomercijalnoPakovanje(Integer komercijalnoPakovanje) {
		this.komercijalnoPakovanje = komercijalnoPakovanje;
	}

	public BigDecimal getMaloprodajnaCena() {
		return this.maloprodajnaCena;
	}

	public void setMaloprodajnaCena(BigDecimal maloprodajnaCena) {
		this.maloprodajnaCena = maloprodajnaCena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public BigDecimal getPromena() {
		return this.promena;
	}

	public void setPromena(BigDecimal promena) {
		this.promena = promena;
	}

	public Integer getRok() {
		return this.rok;
	}

	public void setRok(Integer rok) {
		this.rok = rok;
	}

	public String getTransportniBarKod() {
		return this.transportniBarKod;
	}

	public void setTransportniBarKod(String transportniBarKod) {
		this.transportniBarKod = transportniBarKod;
	}

	public Integer getTransportnihPakovanja() {
		return this.transportnihPakovanja;
	}

	public void setTransportnihPakovanja(Integer transportnihPakovanja) {
		this.transportnihPakovanja = transportnihPakovanja;
	}

	public BigDecimal getZapremina() {
		return this.zapremina;
	}

	public void setZapremina(BigDecimal zapremina) {
		this.zapremina = zapremina;
	}

	public JedMere getJedMere() {
		return this.jedMere;
	}

	public void setJedMere(JedMere jedMere) {
		this.jedMere = jedMere;
	}

	public VrstaAmbal getVrstaAmbal() {
		return this.vrstaAmbal;
	}

	public void setVrstaAmbal(VrstaAmbal vrstaAmbal) {
		this.vrstaAmbal = vrstaAmbal;
	}

	public List<Dnevni> getDnevnis() {
		return this.dnevnis;
	}

	public void setDnevnis(List<Dnevni> dnevnis) {
		this.dnevnis = dnevnis;
	}

	public Dnevni addDnevni(Dnevni dnevni) {
		getDnevnis().add(dnevni);
		dnevni.setArtikl(this);

		return dnevni;
	}

	public Dnevni removeDnevni(Dnevni dnevni) {
		getDnevnis().remove(dnevni);
		dnevni.setArtikl(null);

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
		lager.setArtikl(this);

		return lager;
	}

	public Lager removeLager(Lager lager) {
		getLagers().remove(lager);
		lager.setArtikl(null);

		return lager;
	}

	public List<Mesecni> getMesecnis() {
		return this.mesecnis;
	}

	public void setMesecnis(List<Mesecni> mesecnis) {
		this.mesecnis = mesecnis;
	}

	public Mesecni addMesecni(Mesecni mesecni) {
		getMesecnis().add(mesecni);
		mesecni.setArtikl(this);

		return mesecni;
	}

	public Mesecni removeMesecni(Mesecni mesecni) {
		getMesecnis().remove(mesecni);
		mesecni.setArtikl(null);

		return mesecni;
	}

	public List<Nedeljni> getNedeljnis() {
		return this.nedeljnis;
	}

	public void setNedeljnis(List<Nedeljni> nedeljnis) {
		this.nedeljnis = nedeljnis;
	}

	public Nedeljni addNedeljni(Nedeljni nedeljni) {
		getNedeljnis().add(nedeljni);
		nedeljni.setArtikl(this);

		return nedeljni;
	}

	public Nedeljni removeNedeljni(Nedeljni nedeljni) {
		getNedeljnis().remove(nedeljni);
		nedeljni.setArtikl(null);

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
		nielsen.setArtikl(this);

		return nielsen;
	}

	public Nielsen removeNielsen(Nielsen nielsen) {
		getNielsens().remove(nielsen);
		nielsen.setArtikl(null);

		return nielsen;
	}
	
	public int getId() {
		return idArtikl;
	}

}
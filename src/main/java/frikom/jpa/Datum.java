package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the datum database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@NamedQuery(name="Datum.findAll", query="SELECT d FROM Datum d")
public class Datum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DATUM_IDDATUM_GENERATOR", sequenceName="DATUM_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DATUM_IDDATUM_GENERATOR")
	@Column(name="id_datum")
	private Integer idDatum;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Dnevni
	@OneToMany(mappedBy="datum")
	private List<Dnevni> dnevnis;

	//bi-directional many-to-one association to Mesecni
	@OneToMany(mappedBy="datum1")
	private List<Mesecni> mesecnis1;

	//bi-directional many-to-one association to Mesecni
	@OneToMany(mappedBy="datum2")
	private List<Mesecni> mesecnis2;

	//bi-directional many-to-one association to Nedeljni
	@OneToMany(mappedBy="datum1")
	private List<Nedeljni> nedeljnis1;

	//bi-directional many-to-one association to Nedeljni
	@OneToMany(mappedBy="datum2")
	private List<Nedeljni> nedeljnis2;

	//bi-directional many-to-one association to Nielsen
	@OneToMany(mappedBy="datum1")
	private List<Nielsen> nielsens1;

	//bi-directional many-to-one association to Nielsen
	@OneToMany(mappedBy="datum2")
	private List<Nielsen> nielsens2;

	public Datum() {
	}

	public Integer getIdDatum() {
		return this.idDatum;
	}

	public void setIdDatum(Integer idDatum) {
		this.idDatum = idDatum;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public List<Dnevni> getDnevnis() {
		return this.dnevnis;
	}

	public void setDnevnis(List<Dnevni> dnevnis) {
		this.dnevnis = dnevnis;
	}

	public Dnevni addDnevni(Dnevni dnevni) {
		getDnevnis().add(dnevni);
		dnevni.setDatum(this);

		return dnevni;
	}

	public Dnevni removeDnevni(Dnevni dnevni) {
		getDnevnis().remove(dnevni);
		dnevni.setDatum(null);

		return dnevni;
	}

	public List<Mesecni> getMesecnis1() {
		return this.mesecnis1;
	}

	public void setMesecnis1(List<Mesecni> mesecnis1) {
		this.mesecnis1 = mesecnis1;
	}

	public Mesecni addMesecnis1(Mesecni mesecnis1) {
		getMesecnis1().add(mesecnis1);
		mesecnis1.setDatum1(this);

		return mesecnis1;
	}

	public Mesecni removeMesecnis1(Mesecni mesecnis1) {
		getMesecnis1().remove(mesecnis1);
		mesecnis1.setDatum1(null);

		return mesecnis1;
	}

	public List<Mesecni> getMesecnis2() {
		return this.mesecnis2;
	}

	public void setMesecnis2(List<Mesecni> mesecnis2) {
		this.mesecnis2 = mesecnis2;
	}

	public Mesecni addMesecnis2(Mesecni mesecnis2) {
		getMesecnis2().add(mesecnis2);
		mesecnis2.setDatum2(this);

		return mesecnis2;
	}

	public Mesecni removeMesecnis2(Mesecni mesecnis2) {
		getMesecnis2().remove(mesecnis2);
		mesecnis2.setDatum2(null);

		return mesecnis2;
	}

	public List<Nedeljni> getNedeljnis1() {
		return this.nedeljnis1;
	}

	public void setNedeljnis1(List<Nedeljni> nedeljnis1) {
		this.nedeljnis1 = nedeljnis1;
	}

	public Nedeljni addNedeljnis1(Nedeljni nedeljnis1) {
		getNedeljnis1().add(nedeljnis1);
		nedeljnis1.setDatum1(this);

		return nedeljnis1;
	}

	public Nedeljni removeNedeljnis1(Nedeljni nedeljnis1) {
		getNedeljnis1().remove(nedeljnis1);
		nedeljnis1.setDatum1(null);

		return nedeljnis1;
	}

	public List<Nedeljni> getNedeljnis2() {
		return this.nedeljnis2;
	}

	public void setNedeljnis2(List<Nedeljni> nedeljnis2) {
		this.nedeljnis2 = nedeljnis2;
	}

	public Nedeljni addNedeljnis2(Nedeljni nedeljnis2) {
		getNedeljnis2().add(nedeljnis2);
		nedeljnis2.setDatum2(this);

		return nedeljnis2;
	}

	public Nedeljni removeNedeljnis2(Nedeljni nedeljnis2) {
		getNedeljnis2().remove(nedeljnis2);
		nedeljnis2.setDatum2(null);

		return nedeljnis2;
	}

	public List<Nielsen> getNielsens1() {
		return this.nielsens1;
	}

	public void setNielsens1(List<Nielsen> nielsens1) {
		this.nielsens1 = nielsens1;
	}

	public Nielsen addNielsens1(Nielsen nielsens1) {
		getNielsens1().add(nielsens1);
		nielsens1.setDatum1(this);

		return nielsens1;
	}

	public Nielsen removeNielsens1(Nielsen nielsens1) {
		getNielsens1().remove(nielsens1);
		nielsens1.setDatum1(null);

		return nielsens1;
	}

	public List<Nielsen> getNielsens2() {
		return this.nielsens2;
	}

	public void setNielsens2(List<Nielsen> nielsens2) {
		this.nielsens2 = nielsens2;
	}

	public Nielsen addNielsens2(Nielsen nielsens2) {
		getNielsens2().add(nielsens2);
		nielsens2.setDatum2(this);

		return nielsens2;
	}

	public Nielsen removeNielsens2(Nielsen nielsens2) {
		getNielsens2().remove(nielsens2);
		nielsens2.setDatum2(null);

		return nielsens2;
	}

}
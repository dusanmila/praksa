package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the datum database table.
 * 
 */
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

	//bi-directional many-to-one association to IstorDne
	@JsonIgnore
	@OneToMany(mappedBy="datum")
	private List<IstorDne> istorDnes;

	//bi-directional many-to-one association to IstorMes
	@JsonIgnore
	@OneToMany(mappedBy="datum1")
	private List<IstorMes> istorMes1;

	//bi-directional many-to-one association to IstorMes
	@JsonIgnore
	@OneToMany(mappedBy="datum2")
	private List<IstorMes> istorMes2;

	//bi-directional many-to-one association to IstorNed
	@JsonIgnore
	@OneToMany(mappedBy="datum1")
	private List<IstorNed> istorNeds1;

	//bi-directional many-to-one association to IstorNed
	@JsonIgnore
	@OneToMany(mappedBy="datum2")
	private List<IstorNed> istorNeds2;

	//bi-directional many-to-one association to IstorNiel
	@JsonIgnore
	@OneToMany(mappedBy="datum1")
	private List<IstorNiel> istorNiels1;

	//bi-directional many-to-one association to IstorNiel
	@JsonIgnore
	@OneToMany(mappedBy="datum2")
	private List<IstorNiel> istorNiels2;

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

	public List<IstorDne> getIstorDnes() {
		return this.istorDnes;
	}

	public void setIstorDnes(List<IstorDne> istorDnes) {
		this.istorDnes = istorDnes;
	}

	public IstorDne addIstorDne(IstorDne istorDne) {
		getIstorDnes().add(istorDne);
		istorDne.setDatum(this);

		return istorDne;
	}

	public IstorDne removeIstorDne(IstorDne istorDne) {
		getIstorDnes().remove(istorDne);
		istorDne.setDatum(null);

		return istorDne;
	}

	public List<IstorMes> getIstorMes1() {
		return this.istorMes1;
	}

	public void setIstorMes1(List<IstorMes> istorMes1) {
		this.istorMes1 = istorMes1;
	}

	public IstorMes addIstorMes1(IstorMes istorMes1) {
		getIstorMes1().add(istorMes1);
		istorMes1.setDatum1(this);

		return istorMes1;
	}

	public IstorMes removeIstorMes1(IstorMes istorMes1) {
		getIstorMes1().remove(istorMes1);
		istorMes1.setDatum1(null);

		return istorMes1;
	}

	public List<IstorMes> getIstorMes2() {
		return this.istorMes2;
	}

	public void setIstorMes2(List<IstorMes> istorMes2) {
		this.istorMes2 = istorMes2;
	}

	public IstorMes addIstorMes2(IstorMes istorMes2) {
		getIstorMes2().add(istorMes2);
		istorMes2.setDatum2(this);

		return istorMes2;
	}

	public IstorMes removeIstorMes2(IstorMes istorMes2) {
		getIstorMes2().remove(istorMes2);
		istorMes2.setDatum2(null);

		return istorMes2;
	}

	public List<IstorNed> getIstorNeds1() {
		return this.istorNeds1;
	}

	public void setIstorNeds1(List<IstorNed> istorNeds1) {
		this.istorNeds1 = istorNeds1;
	}

	public IstorNed addIstorNeds1(IstorNed istorNeds1) {
		getIstorNeds1().add(istorNeds1);
		istorNeds1.setDatum1(this);

		return istorNeds1;
	}

	public IstorNed removeIstorNeds1(IstorNed istorNeds1) {
		getIstorNeds1().remove(istorNeds1);
		istorNeds1.setDatum1(null);

		return istorNeds1;
	}

	public List<IstorNed> getIstorNeds2() {
		return this.istorNeds2;
	}

	public void setIstorNeds2(List<IstorNed> istorNeds2) {
		this.istorNeds2 = istorNeds2;
	}

	public IstorNed addIstorNeds2(IstorNed istorNeds2) {
		getIstorNeds2().add(istorNeds2);
		istorNeds2.setDatum2(this);

		return istorNeds2;
	}

	public IstorNed removeIstorNeds2(IstorNed istorNeds2) {
		getIstorNeds2().remove(istorNeds2);
		istorNeds2.setDatum2(null);

		return istorNeds2;
	}

	public List<IstorNiel> getIstorNiels1() {
		return this.istorNiels1;
	}

	public void setIstorNiels1(List<IstorNiel> istorNiels1) {
		this.istorNiels1 = istorNiels1;
	}

	public IstorNiel addIstorNiels1(IstorNiel istorNiels1) {
		getIstorNiels1().add(istorNiels1);
		istorNiels1.setDatum1(this);

		return istorNiels1;
	}

	public IstorNiel removeIstorNiels1(IstorNiel istorNiels1) {
		getIstorNiels1().remove(istorNiels1);
		istorNiels1.setDatum1(null);

		return istorNiels1;
	}

	public List<IstorNiel> getIstorNiels2() {
		return this.istorNiels2;
	}

	public void setIstorNiels2(List<IstorNiel> istorNiels2) {
		this.istorNiels2 = istorNiels2;
	}

	public IstorNiel addIstorNiels2(IstorNiel istorNiels2) {
		getIstorNiels2().add(istorNiels2);
		istorNiels2.setDatum2(this);

		return istorNiels2;
	}

	public IstorNiel removeIstorNiels2(IstorNiel istorNiels2) {
		getIstorNiels2().remove(istorNiels2);
		istorNiels2.setDatum2(null);

		return istorNiels2;
	}

}
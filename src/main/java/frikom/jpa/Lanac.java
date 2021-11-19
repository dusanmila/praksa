package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the lanac database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@NamedQuery(name="Lanac.findAll", query="SELECT l FROM Lanac l")
public class Lanac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LANAC_IDLANAC_GENERATOR", sequenceName="LANAC_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LANAC_IDLANAC_GENERATOR")
	@Column(name="id_lanac")
	private Integer idLanac;

	private String lanac;

	//bi-directional many-to-one association to Objekat
	
	@JsonIgnore
	@OneToMany(mappedBy="lanac")
	private List<Objekat> objekats;

	public Lanac() {
	}

	public Integer getIdLanac() {
		return this.idLanac;
	}

	public void setIdLanac(Integer idLanac) {
		this.idLanac = idLanac;
	}

	public String getLanac() {
		return this.lanac;
	}

	public void setLanac(String lanac) {
		this.lanac = lanac;
	}

	public List<Objekat> getObjekats() {
		return this.objekats;
	}

	public void setObjekats(List<Objekat> objekats) {
		this.objekats = objekats;
	}

	public Objekat addObjekat(Objekat objekat) {
		getObjekats().add(objekat);
		objekat.setLanac(this);

		return objekat;
	}

	public Objekat removeObjekat(Objekat objekat) {
		getObjekats().remove(objekat);
		objekat.setLanac(null);

		return objekat;
	}

}
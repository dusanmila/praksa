package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kateg_obj database table.
 * 
 */
@Entity
@Table(name="kateg_obj")
@NamedQuery(name="KategObj.findAll", query="SELECT k FROM KategObj k")
public class KategObj implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KATEG_OBJ_IDKATEGOBJ_GENERATOR", sequenceName="KATEG_OBJ_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KATEG_OBJ_IDKATEGOBJ_GENERATOR")
	@Column(name="id_kateg_obj")
	private Integer idKategObj;

	@Column(name="naziv_kategorije")
	private String nazivKategorije;

	//bi-directional many-to-one association to Objekat
	@OneToMany(mappedBy="kategObj")
	private List<Objekat> objekats;

	public KategObj() {
	}

	public Integer getIdKategObj() {
		return this.idKategObj;
	}

	public void setIdKategObj(Integer idKategObj) {
		this.idKategObj = idKategObj;
	}

	public String getNazivKategorije() {
		return this.nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

	public List<Objekat> getObjekats() {
		return this.objekats;
	}

	public void setObjekats(List<Objekat> objekats) {
		this.objekats = objekats;
	}

	public Objekat addObjekat(Objekat objekat) {
		getObjekats().add(objekat);
		objekat.setKategObj(this);

		return objekat;
	}

	public Objekat removeObjekat(Objekat objekat) {
		getObjekats().remove(objekat);
		objekat.setKategObj(null);

		return objekat;
	}

}
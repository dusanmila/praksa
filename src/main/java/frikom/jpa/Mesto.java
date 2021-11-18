package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mesto database table.
 * 
 */
@Entity
@NamedQuery(name="Mesto.findAll", query="SELECT m FROM Mesto m")
public class Mesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESTO_IDMESTO_GENERATOR", sequenceName="MESTO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESTO_IDMESTO_GENERATOR")
	@Column(name="id_mesto")
	private Integer idMesto;

	@Column(name="naziv_mesta")
	private String nazivMesta;

	//bi-directional many-to-one association to Objekat
	@OneToMany(mappedBy="mesto")
	private List<Objekat> objekats;

	public Mesto() {
	}

	public Integer getIdMesto() {
		return this.idMesto;
	}

	public void setIdMesto(Integer idMesto) {
		this.idMesto = idMesto;
	}

	public String getNazivMesta() {
		return this.nazivMesta;
	}

	public void setNazivMesta(String nazivMesta) {
		this.nazivMesta = nazivMesta;
	}

	public List<Objekat> getObjekats() {
		return this.objekats;
	}

	public void setObjekats(List<Objekat> objekats) {
		this.objekats = objekats;
	}

	public Objekat addObjekat(Objekat objekat) {
		getObjekats().add(objekat);
		objekat.setMesto(this);

		return objekat;
	}

	public Objekat removeObjekat(Objekat objekat) {
		getObjekats().remove(objekat);
		objekat.setMesto(null);

		return objekat;
	}

}
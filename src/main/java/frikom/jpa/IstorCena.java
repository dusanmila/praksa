package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the istor_cena database table.
 * 
 */
@Entity
@Table(name="istor_cena")
@NamedQuery(name="IstorCena.findAll", query="SELECT i FROM IstorCena i")
public class IstorCena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ISTOR_CENA_IDISTORCENA_GENERATOR", sequenceName="ISTOR_CENA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ISTOR_CENA_IDISTORCENA_GENERATOR")
	@Column(name="id_istor_cena")
	private Integer idIstorCena;

	public IstorCena() {
	}

	public Integer getIdIstorCena() {
		return this.idIstorCena;
	}

	public void setIdIstorCena(Integer idIstorCena) {
		this.idIstorCena = idIstorCena;
	}

}
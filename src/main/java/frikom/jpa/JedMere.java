package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jed_mere database table.
 * 
 */
@Entity
@Table(name="jed_mere")
@NamedQuery(name="JedMere.findAll", query="SELECT j FROM JedMere j")
public class JedMere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JED_MERE_IDJEDMERE_GENERATOR", sequenceName="JED_MERE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JED_MERE_IDJEDMERE_GENERATOR")
	@Column(name="id_jed_mere")
	private Integer idJedMere;

	@Column(name="jedinica_mere")
	private String jedinicaMere;

	//bi-directional many-to-one association to Artikl
	@OneToMany(mappedBy="jedMere")
	private List<Artikl> artikls;

	public JedMere() {
	}

	public Integer getIdJedMere() {
		return this.idJedMere;
	}

	public void setIdJedMere(Integer idJedMere) {
		this.idJedMere = idJedMere;
	}

	public String getJedinicaMere() {
		return this.jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public List<Artikl> getArtikls() {
		return this.artikls;
	}

	public void setArtikls(List<Artikl> artikls) {
		this.artikls = artikls;
	}

	public Artikl addArtikl(Artikl artikl) {
		getArtikls().add(artikl);
		artikl.setJedMere(this);

		return artikl;
	}

	public Artikl removeArtikl(Artikl artikl) {
		getArtikls().remove(artikl);
		artikl.setJedMere(null);

		return artikl;
	}

}
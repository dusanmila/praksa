package frikom.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the vrsta_ambal database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name="vrsta_ambal")
@NamedQuery(name="VrstaAmbal.findAll", query="SELECT v FROM VrstaAmbal v")
public class VrstaAmbal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VRSTA_AMBAL_IDVRSTAAMBALAZE_GENERATOR", sequenceName="VRSTA_AMBAL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VRSTA_AMBAL_IDVRSTAAMBALAZE_GENERATOR")
	@Column(name="id_vrsta_ambalaze")
	private Integer idVrstaAmbalaze;

	@Column(name="vrsta_ambalaze")
	private String vrstaAmbalaze;

	//bi-directional many-to-one association to Artikl
	@JsonIgnore
	@OneToMany(mappedBy="vrstaAmbal")
	private List<Artikl> artikls;

	public VrstaAmbal() {
	}

	public Integer getIdVrstaAmbalaze() {
		return this.idVrstaAmbalaze;
	}

	public void setIdVrstaAmbalaze(Integer idVrstaAmbalaze) {
		this.idVrstaAmbalaze = idVrstaAmbalaze;
	}

	public String getVrstaAmbalaze() {
		return this.vrstaAmbalaze;
	}

	public void setVrstaAmbalaze(String vrstaAmbalaze) {
		this.vrstaAmbalaze = vrstaAmbalaze;
	}

	public List<Artikl> getArtikls() {
		return this.artikls;
	}

	public void setArtikls(List<Artikl> artikls) {
		this.artikls = artikls;
	}

	public Artikl addArtikl(Artikl artikl) {
		getArtikls().add(artikl);
		artikl.setVrstaAmbal(this);

		return artikl;
	}

	public Artikl removeArtikl(Artikl artikl) {
		getArtikls().remove(artikl);
		artikl.setVrstaAmbal(null);

		return artikl;
	}

	public int getId() {
		return idVrstaAmbalaze;
	}
	
}
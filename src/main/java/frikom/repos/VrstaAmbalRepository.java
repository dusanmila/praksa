package frikom.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.VrstaAmbal;

public interface VrstaAmbalRepository extends JpaRepository<VrstaAmbal,Integer> {

	public Collection<VrstaAmbal> findByvrstaAmbalazeContainingIgnoreCase(String vrstaAmbalaze);
	
}
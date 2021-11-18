package frikom.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.Artikl;


public interface ArtiklRepository extends JpaRepository<Artikl,Integer> {
	
	Collection<Artikl> findBynazivContainingIgnoreCase(String naziv);
	
	

}
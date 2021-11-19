package frikom.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.JedMere;

public interface JedMereRepository extends JpaRepository<JedMere,Integer> {
	
	public Collection<JedMere> findByjedinicaMereContainingIgnoreCase(String jedinicaMere);

}

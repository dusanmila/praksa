package frikom.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.Lanac;

public interface LanacRepository extends JpaRepository<Lanac, Integer> {

	Collection<Lanac> findByLanacContainingIgnoreCase(String naziv);

}

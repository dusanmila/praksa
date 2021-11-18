package frikom.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.Mesto;

public interface MestoRepository extends JpaRepository<Mesto, Integer> {

	Collection<Mesto> findMestoByNazivMestaContainingIgnoreCase(String naziv);
	
}

package frikom.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.Objekat;

public interface ObjekatRepository extends JpaRepository<Objekat, Integer> {

	Collection<Objekat> findObjekatByNazivObjektaContainingIgnoreCase(String naziv);

}

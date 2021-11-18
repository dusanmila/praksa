package frikom.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.KategObj;

public interface KategObjRepository extends JpaRepository<KategObj, Integer> {

	Collection<KategObj> findByNazivKategorijeContainingIgnoreCase(String naziv);

}
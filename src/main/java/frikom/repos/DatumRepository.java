package frikom.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.Datum;

public interface DatumRepository extends JpaRepository<Datum, Integer> {

}

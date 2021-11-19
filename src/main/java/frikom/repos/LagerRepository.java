package frikom.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.Lager;

public interface LagerRepository extends JpaRepository<Lager, Integer> {

}

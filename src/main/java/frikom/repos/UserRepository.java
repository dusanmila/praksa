package frikom.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import frikom.jpa.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	public Collection<User> findByusernameContainingIgnoreCase(String username);
	
}
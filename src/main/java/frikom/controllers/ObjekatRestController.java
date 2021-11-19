package frikom.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import frikom.jpa.Objekat;
import frikom.repos.ObjekatRepository;

@CrossOrigin
@RestController
public class ObjekatRestController {

	@Autowired
	private ObjekatRepository objekatRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("objekat")
	public Collection<Objekat> getObjekti() {
		return objekatRepository.findAll();
	}

	@GetMapping("objekat/{id}")
	public Objekat getObjekat(@PathVariable("id") Integer id) {
		return objekatRepository.getById(id);
	}

//	@GetMapping("objekat/{naziv}")
//	public Collection<Objekat> getObjekatByNaziv(@PathVariable("naziv") String naziv) {
//		return objekatRepository.findObjekatByNazivObjektaContainingIgnoreCase(naziv);
//	}

	@PostMapping("objekat")
	public ResponseEntity<Objekat> insertObjekat(@RequestBody Objekat objekat) {
		if (!objekatRepository.existsById(objekat.getIdObjekat())) {
			objekatRepository.save(objekat);
			return new ResponseEntity<Objekat>(HttpStatus.OK);
		}
		return new ResponseEntity<Objekat>(HttpStatus.CONFLICT);
	}

	@PutMapping("objekat")
	public ResponseEntity<Objekat> updateObjekat(@RequestBody Objekat objekat) {
		if (!objekatRepository.existsById(objekat.getIdObjekat())) {
			return new ResponseEntity<Objekat>(HttpStatus.CONFLICT);
		}
		objekatRepository.save(objekat);
		return new ResponseEntity<Objekat>(HttpStatus.OK);
	}

	@DeleteMapping("objekat/{id}")
	public ResponseEntity<Objekat> deleteObjekat(@PathVariable("id") Integer id) {
		if (!objekatRepository.existsById(id)) {
			return new ResponseEntity<Objekat>(HttpStatus.CONFLICT);
		}
		objekatRepository.deleteById(id);
		return new ResponseEntity<Objekat>(HttpStatus.OK);
	}

}

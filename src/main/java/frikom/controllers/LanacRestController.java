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

import frikom.jpa.Lanac;
import frikom.repos.LanacRepository;

@CrossOrigin
@RestController
public class LanacRestController {

	@Autowired
	private LanacRepository lanacRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("lanac")
	public Collection<Lanac> getLanci() {
		return lanacRepository.findAll();
	}

	@GetMapping("lanac/{id}")
	public Lanac getLanac(@PathVariable("id") Integer id) {
		return lanacRepository.getById(id);
	}

//	@GetMapping("lanac/{naziv}")
//	public Collection<Lanac> getLanacByNaziv(@PathVariable("naziv") String naziv) {
//		return lanacRepository.findByLanacContainingIgnoreCase(naziv);
//	}

	@PostMapping("lanac")
	public ResponseEntity<Lanac> insertLanac(@RequestBody Lanac lanac) {
		if (!lanacRepository.existsById(lanac.getIdLanac())) {
			lanacRepository.save(lanac);
			return new ResponseEntity<Lanac>(HttpStatus.OK);
		}
		return new ResponseEntity<Lanac>(HttpStatus.CONFLICT);
	}

	@PutMapping("lanac")
	public ResponseEntity<Lanac> updateLanac(@RequestBody Lanac lanac) {
		if (!lanacRepository.existsById(lanac.getIdLanac())) {
			return new ResponseEntity<Lanac>(HttpStatus.CONFLICT);
		}
		lanacRepository.save(lanac);
		return new ResponseEntity<Lanac>(HttpStatus.OK);
	}

	@DeleteMapping("lanac/{id}")
	public ResponseEntity<Lanac> deleteLanac(@PathVariable("id") Integer id) {
		if (!lanacRepository.existsById(id)) {
			return new ResponseEntity<Lanac>(HttpStatus.CONFLICT);
		}
		lanacRepository.deleteById(id);
		return new ResponseEntity<Lanac>(HttpStatus.OK);
	}

}

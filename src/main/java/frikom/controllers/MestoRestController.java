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

import frikom.jpa.Mesto;
import frikom.repos.MestoRepository;

@CrossOrigin
@RestController
public class MestoRestController {

	@Autowired
	private MestoRepository mestoRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("mesto")
	public Collection<Mesto> getMesta() {
		return mestoRepository.findAll();
	}

	@GetMapping("mesto/{id}")
	public Mesto getMesto(@PathVariable("id") Integer id) {
		return mestoRepository.getById(id);
	}

//	@GetMapping("mesto/{naziv}")
//	public Collection<Mesto> getMestoByNaziv(@PathVariable("naziv") String naziv) {
//		return mestoRepository.findMestoByNazivMestaContainingIgnoreCase(naziv);
//	}

	@PostMapping("mesto")
	public ResponseEntity<Mesto> insertMesto(@RequestBody Mesto mesto) {
		if (!mestoRepository.existsById(mesto.getIdMesto())) {
			mestoRepository.save(mesto);
			return new ResponseEntity<Mesto>(HttpStatus.OK);
		}
		return new ResponseEntity<Mesto>(HttpStatus.CONFLICT);
	}

	@PutMapping("mesto")
	public ResponseEntity<Mesto> updateMesto(@RequestBody Mesto mesto) {
		if (!mestoRepository.existsById(mesto.getIdMesto())) {
			return new ResponseEntity<Mesto>(HttpStatus.CONFLICT);
		}
		mestoRepository.save(mesto);
		return new ResponseEntity<Mesto>(HttpStatus.OK);
	}

	@DeleteMapping("mesto/{id}")
	public ResponseEntity<Mesto> deleteMesto(@PathVariable("id") Integer id) {
		if (!mestoRepository.existsById(id)) {
			return new ResponseEntity<Mesto>(HttpStatus.CONFLICT);
		}
		mestoRepository.deleteById(id);
		return new ResponseEntity<Mesto>(HttpStatus.OK);
	}

}

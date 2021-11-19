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

import frikom.jpa.Kategorija;
import frikom.repos.KategorijaRepository;

@CrossOrigin
@RestController
public class KategorijaRestController {

	@Autowired
	private KategorijaRepository kategorijaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("kategorija")
	public Collection<Kategorija> getKategorije() {
		return kategorijaRepository.findAll();
	}

	@GetMapping("kategorija/{id}")
	public Kategorija getKategorija(@PathVariable("id") Integer id) {
		return kategorijaRepository.getById(id);
	}

	@PostMapping("kategorija")
	public ResponseEntity<Kategorija> insertKategorija(@RequestBody Kategorija kategorija) {
		if (!kategorijaRepository.existsById(kategorija.getIdKategorija())) {
			kategorijaRepository.save(kategorija);
			return new ResponseEntity<Kategorija>(HttpStatus.OK);
		}
		return new ResponseEntity<Kategorija>(HttpStatus.CONFLICT);
	}

	@PutMapping("kategorija")
	public ResponseEntity<Kategorija> updateKategorija(@RequestBody Kategorija kategorija) {
		if (!kategorijaRepository.existsById(kategorija.getIdKategorija())) {
			return new ResponseEntity<Kategorija>(HttpStatus.CONFLICT);
		}
		kategorijaRepository.save(kategorija);
		return new ResponseEntity<Kategorija>(HttpStatus.OK);
	}

	@DeleteMapping("kategorija/{id}")
	public ResponseEntity<Kategorija> deleteKategorija(@PathVariable("id") Integer id) {
		if (!kategorijaRepository.existsById(id)) {
			return new ResponseEntity<Kategorija>(HttpStatus.CONFLICT);
		}
		kategorijaRepository.deleteById(id);
		return new ResponseEntity<Kategorija>(HttpStatus.OK);
	}

}

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "Category REST controller")
public class KategorijaRestController {

	@Autowired
	private KategorijaRepository kategorijaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("kategorija")
	@ApiOperation(value = "Returns all categories")
	public Collection<Kategorija> getKategorije() {
		return kategorijaRepository.findAll();
	}

	@GetMapping("kategorija/{id}")
	@ApiOperation(value = "Returns a category by id")
	public Kategorija getKategorija(@PathVariable("id") Integer id) {
		return kategorijaRepository.getById(id);
	}

	@PostMapping("kategorija")
	@ApiOperation(value = "Inserts a new category")
	public ResponseEntity<Kategorija> insertKategorija(@RequestBody Kategorija kategorija) {
		if (!kategorijaRepository.existsById(kategorija.getIdKategorija())) {
			kategorijaRepository.save(kategorija);
			return new ResponseEntity<Kategorija>(HttpStatus.OK);
		}
		return new ResponseEntity<Kategorija>(HttpStatus.CONFLICT);
	}

	@PutMapping("kategorija")
	@ApiOperation(value = "Updates an existing category")
	public ResponseEntity<Kategorija> updateKategorija(@RequestBody Kategorija kategorija) {
		if (!kategorijaRepository.existsById(kategorija.getIdKategorija())) {
			return new ResponseEntity<Kategorija>(HttpStatus.CONFLICT);
		}
		kategorijaRepository.save(kategorija);
		return new ResponseEntity<Kategorija>(HttpStatus.OK);
	}

	@DeleteMapping("kategorija/{id}")
	@ApiOperation(value = "Deletes an existing category")
	public ResponseEntity<Kategorija> deleteKategorija(@PathVariable("id") Integer id) {
		if (!kategorijaRepository.existsById(id)) {
			return new ResponseEntity<Kategorija>(HttpStatus.CONFLICT);
		}
		kategorijaRepository.deleteById(id);
		return new ResponseEntity<Kategorija>(HttpStatus.OK);
	}

}

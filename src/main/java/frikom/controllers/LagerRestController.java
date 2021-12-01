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

import frikom.jpa.Lager;
import frikom.repos.LagerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "Stock REST controller")
public class LagerRestController {

	@Autowired
	private LagerRepository lagerRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("lager")
	@ApiOperation(value = "Returns all stocks")
	public Collection<Lager> getLageri() {
		return lagerRepository.findAll();
	}

	@GetMapping("lager/{id}")
	@ApiOperation(value = "Returns a stock by id")
	public Lager getLager(@PathVariable("id") Integer id) {
		return lagerRepository.getById(id);
	}

	@PostMapping("lager")
	@ApiOperation(value = "Inserts a new stock")
	public ResponseEntity<Lager> insertLager(@RequestBody Lager lager) {
		if (!lagerRepository.existsById(lager.getIdLager())) {
			lagerRepository.save(lager);
			return new ResponseEntity<Lager>(HttpStatus.OK);
		}
		return new ResponseEntity<Lager>(HttpStatus.CONFLICT);
	}

	@PutMapping("lager")
	@ApiOperation(value = "Updates an existing stock")
	public ResponseEntity<Lager> updateLager(@RequestBody Lager lager) {
		if (!lagerRepository.existsById(lager.getIdLager())) {
			return new ResponseEntity<Lager>(HttpStatus.CONFLICT);
		}
		lagerRepository.save(lager);
		return new ResponseEntity<Lager>(HttpStatus.OK);
	}

	@DeleteMapping("lager/{id}")
	@ApiOperation(value = "Deletes an existing stock")
	public ResponseEntity<Lager> deleteLager(@PathVariable("id") Integer id) {
		if (!lagerRepository.existsById(id)) {
			return new ResponseEntity<Lager>(HttpStatus.CONFLICT);
		}
		lagerRepository.deleteById(id);
		return new ResponseEntity<Lager>(HttpStatus.OK);
	}

}

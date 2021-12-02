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

import frikom.jpa.Datum;
import frikom.repos.DatumRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = {"Date REST controller"})
public class DatumRestController {

	@Autowired
	private DatumRepository datumRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("datum")
	@ApiOperation(value = "Returns all the dates from database")
	public Collection<Datum> getDatumi() {
		return datumRepository.findAll();
	}

	@GetMapping("datum/{id}")
	@ApiOperation(value = "Returns a date by id")
	public Datum getDatum(@PathVariable("id") Integer id) {
		return datumRepository.getById(id);
	}

	@PostMapping("datum")
	@ApiOperation(value = "Inserts a new date")
	public ResponseEntity<Datum> insertDatum(@RequestBody Datum datum) {
		if (!datumRepository.existsById(datum.getIdDatum())) {
			datumRepository.save(datum);
			return new ResponseEntity<Datum>(HttpStatus.OK);
		}
		return new ResponseEntity<Datum>(HttpStatus.CONFLICT);
	}

	@PutMapping("datum")
	@ApiOperation(value = "Replaces an existing date in the database")
	public ResponseEntity<Datum> updateDatum(@RequestBody Datum datum) {
		if (!datumRepository.existsById(datum.getIdDatum())) {
			return new ResponseEntity<Datum>(HttpStatus.CONFLICT);
		}
		datumRepository.save(datum);
		return new ResponseEntity<Datum>(HttpStatus.OK);
	}

	@DeleteMapping("datum/{id}")
	@ApiOperation(value = "Deletes an existing date")
	public ResponseEntity<Datum> deleteDatum(@PathVariable("id") Integer id) {
		if (!datumRepository.existsById(id)) {
			return new ResponseEntity<Datum>(HttpStatus.CONFLICT);
		}
		datumRepository.deleteById(id);
		return new ResponseEntity<Datum>(HttpStatus.OK);
	}

}

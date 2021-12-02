package frikom.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import frikom.jpa.Artikl;
import frikom.jpa.JedMere;
import frikom.jpa.VrstaAmbal;
import frikom.repos.JedMereRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "Measurement unit REST controller")
public class JedMereRestController {

	@Autowired
	private JedMereRepository jedMereRepository;
	
	@GetMapping("jedmere")
	@ApiOperation(value = "Returns all measurement units")
	public Collection<JedMere> getJedMere(){
		return jedMereRepository.findAll();
	}
	
	@GetMapping("jedmere/{id}")
	@ApiOperation(value = "Returns a measurement unit by id")
	public JedMere getJedMereByID(@PathVariable ("id") Integer id) {
		return jedMereRepository.getById(id);
	}
	
	@GetMapping("jedmere/{naziv}")
	@ApiOperation(value = "Returns a measurement unit by name")
	public Collection<JedMere> getJedMereByNaziv(@PathVariable ("naziv") String naziv) {
		return jedMereRepository.findByjedinicaMereContainingIgnoreCase(naziv);
	}
	
	@PostMapping("jedmere")
	@ApiOperation(value = "Inserts a new measurement unit")
	public ResponseEntity<JedMere> insertJedMere(@RequestBody JedMere jedmere){
		if(!jedMereRepository.existsById(jedmere.getIdJedMere())) {
			jedMereRepository.save(jedmere);
			
			return new ResponseEntity<JedMere>(HttpStatus.OK);
		}else {
			return new ResponseEntity<JedMere>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("jedmere")
	@ApiOperation(value = "Updates an existing measurement unit")
	public ResponseEntity<JedMere> updateJedMere(@RequestBody JedMere jedmere){
		if(!jedMereRepository.existsById(jedmere.getIdJedMere())) {
			
			return new ResponseEntity<JedMere>(HttpStatus.NO_CONTENT);
		}else {
			jedMereRepository.save(jedmere);
			return new ResponseEntity<JedMere>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("jedmere/{id}")
	@ApiOperation(value = "Deletes an existing measurement unit")
	public ResponseEntity<JedMere> deleteJedMere(@PathVariable("id") Integer id){
if(!jedMereRepository.existsById(id)) {
			return new ResponseEntity<JedMere>(HttpStatus.NO_CONTENT);
		}else {
			
			//jdbcTemplate.execute("delete from departman where fakultet = " + id);
			jedMereRepository.deleteById(id);
			
			
			return new ResponseEntity<JedMere>(HttpStatus.OK);
		}
	}
	
}
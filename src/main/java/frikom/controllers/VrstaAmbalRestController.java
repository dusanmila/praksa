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
import frikom.repos.VrstaAmbalRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "Packaging type REST controller")
public class VrstaAmbalRestController {
	
	@Autowired
	private VrstaAmbalRepository vrstaAmbalRepository;
	
	@GetMapping("vrstaambal")
	@ApiOperation(value = "Returns all packaging types")
	public Collection<VrstaAmbal> getVrsteAmbal(){
		
		return vrstaAmbalRepository.findAll();
		
	}
	
	@GetMapping("vrstaambal/{id}")
	@ApiOperation(value = "Returns a packaging type by id")
	public VrstaAmbal getVrstaAmbalByID(@PathVariable ("id") Integer id) {
		return vrstaAmbalRepository.getById(id);
	}
	
//	@GetMapping("jedmere/{naziv}")
	// 	@ApiOperation(value = "Returns a packaging type by name")
//	public Collection<VrstaAmbal> getVrstaAmbalByNaziv(@PathVariable ("naziv") String naziv) {
//		return vrstaAmbalRepository.findByvrstaAmbalazeContainingIgnoreCase(naziv);
//	}
	
	@PostMapping("vrstaambal")
	@ApiOperation(value = "Inserts a new packaging type")
	public ResponseEntity<VrstaAmbal> insertVrstaAmbal(@RequestBody VrstaAmbal vrstaambal){
		if(!vrstaAmbalRepository.existsById(vrstaambal.getIdVrstaAmbalaze())) {
			vrstaAmbalRepository.save(vrstaambal);
			
			return new ResponseEntity<VrstaAmbal>(HttpStatus.OK);
		}else {
			return new ResponseEntity<VrstaAmbal>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("vrstaambal")
	@ApiOperation(value = "Updates an existing packaging type")
	public ResponseEntity<VrstaAmbal> updateVrstaAmbal(@RequestBody VrstaAmbal vrstaambal){
		if(!vrstaAmbalRepository.existsById(vrstaambal.getIdVrstaAmbalaze())) {
			
			return new ResponseEntity<VrstaAmbal>(HttpStatus.NO_CONTENT);
		}else {
			vrstaAmbalRepository.save(vrstaambal);
			return new ResponseEntity<VrstaAmbal>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("vrstaambal/{id}")
	@ApiOperation(value = "Deletes an existing packaging type")
	public ResponseEntity<VrstaAmbal> deleteVrstaAmbal(@PathVariable("id") Integer id){
if(!vrstaAmbalRepository.existsById(id)) {
			return new ResponseEntity<VrstaAmbal>(HttpStatus.NO_CONTENT);
		}else {
			
			//jdbcTemplate.execute("delete from departman where fakultet = " + id);
			vrstaAmbalRepository.deleteById(id);
			
			
			return new ResponseEntity<VrstaAmbal>(HttpStatus.OK);
		}
	}
	

}
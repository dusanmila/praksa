package frikom.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import frikom.jpa.Artikl;
import frikom.repos.ArtiklRepository;

@CrossOrigin
@RestController
public class ArtiklRestController {

	@Autowired	
	private ArtiklRepository artiklRepository;

	@GetMapping("artikl")
	public Collection<Artikl> getArtikls() {
		return artiklRepository.findAll();
	}
	

	
	@GetMapping("artikl/{naziv}")
	public Collection<Artikl> getArtiklByNaziv(@PathVariable ("naziv") String naziv) {
		return artiklRepository.findBynazivContainingIgnoreCase(naziv);
	}
	
	
	@GetMapping("artikl/{id}")
	public Artikl getArtiklByID(@PathVariable ("id") Integer id) {
		return artiklRepository.getById(id);
	}
	
	@PostMapping("artikl")
	public ResponseEntity<Artikl> insertArtikl(@RequestBody Artikl artikl){
		if(!artiklRepository.existsById(artikl.getId())) {
			artiklRepository.save(artikl);
			
			return new ResponseEntity<Artikl>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Artikl>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("artikl")
	public ResponseEntity<Artikl> updateArtikl(@RequestBody Artikl artikl){
		if(!artiklRepository.existsById(artikl.getId())) {
			
			return new ResponseEntity<Artikl>(HttpStatus.NO_CONTENT);
		}else {
			artiklRepository.save(artikl);
			return new ResponseEntity<Artikl>(HttpStatus.OK);
		}
	}
	
}
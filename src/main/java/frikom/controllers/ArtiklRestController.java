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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = {"Article REST controller"})
public class ArtiklRestController {

	@Autowired	
	private ArtiklRepository artiklRepository;

	@GetMapping("artikl")
	@ApiOperation(value = "Returns all the articles from the database")
	public Collection<Artikl> getArtikls() {
		return artiklRepository.findAll();
	}
	

	
	@GetMapping("artikl/{naziv}")
	@ApiOperation(value = "Returns articles by article name")
	public Collection<Artikl> getArtiklByNaziv(@PathVariable ("naziv") String naziv) {
		return artiklRepository.findBynazivContainingIgnoreCase(naziv);
	}
	
	
	@GetMapping("artikl/{id}")
	@ApiOperation(value = "Returns article by id")
	public Artikl getArtiklByID(@PathVariable ("id") Integer id) {
		return artiklRepository.getById(id);
	}
	
	@PostMapping("artikl")
	@ApiOperation(value = "Inserts a new article")
	public ResponseEntity<Artikl> insertArtikl(@RequestBody Artikl artikl){
		if(!artiklRepository.existsById(artikl.getIdArtikl())) {
			artiklRepository.save(artikl);
			
			return new ResponseEntity<Artikl>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Artikl>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("artikl")
	@ApiOperation(value = "Updates an article")
	public ResponseEntity<Artikl> updateArtikl(@RequestBody Artikl artikl){
		if(!artiklRepository.existsById(artikl.getIdArtikl())) {
			
			return new ResponseEntity<Artikl>(HttpStatus.NO_CONTENT);
		}else {
			artiklRepository.save(artikl);
			return new ResponseEntity<Artikl>(HttpStatus.OK);
		}
	}
	
}

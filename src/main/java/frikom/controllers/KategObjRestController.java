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

import frikom.jpa.KategObj;
import frikom.repos.KategObjRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "Object category REST controller")
public class KategObjRestController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private KategObjRepository kategObjRepository;

	@GetMapping("kategObj")
	@ApiOperation(value = "Returns all object categories")
	public Collection<KategObj> getKategObjekata() {
		return kategObjRepository.findAll();
	}

	@GetMapping("kategObj/{id}")
	@ApiOperation(value = "Returns an object category by id")
	public KategObj getKategObj(@PathVariable("id") Integer id) {
		return kategObjRepository.getById(id);
	}

//	@GetMapping("kategObj/{naziv}")
	//@ApiOperation(value = "Returns an object category by id")
//	public Collection<KategObj> getKategObjByNaziv(@PathVariable("naziv") String naziv) {
//		return kategObjRepository.findByNazivKategorijeContainingIgnoreCase(naziv);
//	}

	@PostMapping("kategObj")
	@ApiOperation(value = "Inserts a new object category")
	public ResponseEntity<KategObj> insertKategObj(@RequestBody KategObj kategObj) {
		if (!kategObjRepository.existsById(kategObj.getIdKategObj())) {
			kategObjRepository.save(kategObj);
			return new ResponseEntity<KategObj>(HttpStatus.OK);
		}
		return new ResponseEntity<KategObj>(HttpStatus.CONFLICT);
	}

	@PutMapping("kategObj")
	@ApiOperation(value = "Updates an existing object category")
	public ResponseEntity<KategObj> updateKategObj(@RequestBody KategObj kategObj) {
		if (!kategObjRepository.existsById(kategObj.getIdKategObj())) {
			return new ResponseEntity<KategObj>(HttpStatus.CONFLICT);
		}
		kategObjRepository.save(kategObj);
		return new ResponseEntity<KategObj>(HttpStatus.OK);
	}

	@DeleteMapping("kategObj/{id}")
	@ApiOperation(value = "Deletes an existing object category")
	public ResponseEntity<KategObj> deleteKategObj(@PathVariable("id") Integer id) {
		if (!kategObjRepository.existsById(id)) {
			return new ResponseEntity<KategObj>(HttpStatus.CONFLICT);
		}
		kategObjRepository.deleteById(id);
		return new ResponseEntity<KategObj>(HttpStatus.OK);
	}

}
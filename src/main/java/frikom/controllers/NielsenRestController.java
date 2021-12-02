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

import frikom.jpa. Nielsen;
import frikom.repos. NielsenRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "Nielsen REST controller")
public class  NielsenRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NielsenRepository nielsenRepository;

    @GetMapping("nielsen")
	@ApiOperation(value = "Returns all Nielsen reports")
    public Collection< Nielsen> getNielsen(){
    	
        return nielsenRepository.findAll();
    }
    
    @GetMapping("nielsen/{id}")
	@ApiOperation(value = "Returns a Nielsen report by id")
    public Nielsen getNielsen(@PathVariable ("id") Integer id) {
    	
        return nielsenRepository.getById(id);
    }
    
  
    @PostMapping("nielsen")
	@ApiOperation(value = "Inserts a new Nielsen")
    public ResponseEntity<Nielsen> insertNielsen(@RequestBody Nielsen nielsen){
        if(!nielsenRepository.existsById(nielsen.getIdNielsen())) {
        	nielsenRepository.save(nielsen);
        	
            return new ResponseEntity<Nielsen>(HttpStatus.OK);
        }
        else {
        	
            return new ResponseEntity<Nielsen>(HttpStatus.CONFLICT);
        }
    }
     
    @PutMapping("nielsen")
	@ApiOperation(value = "Updates an existing Nielsen")
    public ResponseEntity<Nielsen> updateNielsen(@RequestBody Nielsen nielsen){
        if(!nielsenRepository.existsById(nielsen.getIdNielsen())) {
            
            return new ResponseEntity<Nielsen>(HttpStatus.NO_CONTENT);
        }
        else {
        	nielsenRepository.save(nielsen);
        	
            return new ResponseEntity<Nielsen>(HttpStatus.OK);
        }
    }
    
    @DeleteMapping("nielsen/{id}")
	@ApiOperation(value = "Deletes an existing Nielsen")
    public ResponseEntity<Nielsen> deleteNielsen(@PathVariable("id") Integer id){
    	if(!nielsenRepository.existsById(id)) {
            return new ResponseEntity<Nielsen>(HttpStatus.NO_CONTENT);
        }
    	nielsenRepository.deleteById(id);
        return new ResponseEntity<Nielsen>(HttpStatus.OK);
        
    }

}
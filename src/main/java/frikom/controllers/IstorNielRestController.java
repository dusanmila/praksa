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

import frikom.jpa. IstorNiel;
import frikom.jpa.KategObj;
import frikom.repos. IstorNielRepository;
 
@CrossOrigin
@RestController
public class  IstorNielRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IstorNielRepository istorNielRepository;

    @GetMapping("istorNiel")
    public Collection< IstorNiel> getIstorNiel(){
    	
        return istorNielRepository.findAll();
    }
    
    @GetMapping("istorNiel/{id}")
    public IstorNiel getIstorNiel(@PathVariable ("id") Integer id) {
    	
        return istorNielRepository.getById(id);
    }
    
  
    @PostMapping("istorNiel")
    public ResponseEntity<IstorNiel> insertIstorNiel(@RequestBody IstorNiel istorNiel){
        if(!istorNielRepository.existsById(istorNiel.getIdIstorNiel())) {
        	istorNielRepository.save(istorNiel);
        	
            return new ResponseEntity<IstorNiel>(HttpStatus.OK);
        }
        else {
        	
            return new ResponseEntity<IstorNiel>(HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("istorNiel")
    public ResponseEntity<IstorNiel> updateIstorNiel(@RequestBody IstorNiel istorNiel){
        if(!istorNielRepository.existsById(istorNiel.getIdIstorNiel())) {
            
            return new ResponseEntity<IstorNiel>(HttpStatus.NO_CONTENT);
        }
        else {
        	istorNielRepository.save(istorNiel);
        	
            return new ResponseEntity<IstorNiel>(HttpStatus.OK);
        }
    }
    
    @DeleteMapping("istorNiel/{id}")
    public ResponseEntity<IstorNiel> deleteIstorNiel(@PathVariable("id") Integer id){
    	if(!istorNielRepository.existsById(id)) {
            return new ResponseEntity<IstorNiel>(HttpStatus.NO_CONTENT);
        }
    	
    	istorNielRepository.deleteById(id);
		
            return new ResponseEntity<IstorNiel>(HttpStatus.OK);
        }
    

}
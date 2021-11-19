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

import frikom.jpa. IstorNed;
import frikom.repos. IstorNedRepository;
 
@CrossOrigin
@RestController
public class  IstorNedRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IstorNedRepository istorNedRepository;

    @GetMapping("istorNed")
    public Collection< IstorNed> getIstorNed(){
    	
        return istorNedRepository.findAll();
    }
    
    @GetMapping("istorNed/{id}")
    public IstorNed getIstorNed(@PathVariable ("id") Integer id) {
    	
        return istorNedRepository.getById(id);
    }
    
  
    @PostMapping("istorNed")
    public ResponseEntity<IstorNed> insertIstorNed(@RequestBody IstorNed istorNed){
        if(!istorNedRepository.existsById(istorNed.getIdIstorNed())) {
        	istorNedRepository.save(istorNed);
        	
            return new ResponseEntity<IstorNed>(HttpStatus.OK);
        }
        else {
        	
            return new ResponseEntity<IstorNed>(HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("istorNed")
    public ResponseEntity<IstorNed> updateIstorNed(@RequestBody IstorNed istorNed){
        if(!istorNedRepository.existsById(istorNed.getIdIstorNed())) {
            
            return new ResponseEntity<IstorNed>(HttpStatus.NO_CONTENT);
        }
        else {
        	istorNedRepository.save(istorNed);
        	
            return new ResponseEntity<IstorNed>(HttpStatus.OK);
        }
    }
    
    @DeleteMapping("istorNed/{id}")
    public ResponseEntity<IstorNed> deleteIstorNed(@PathVariable("id") Integer id){
    	if(!istorNedRepository.existsById(id)) {
            return new ResponseEntity<IstorNed>(HttpStatus.NO_CONTENT);
        }
    	istorNedRepository.deleteById(id);
            return new ResponseEntity<IstorNed>(HttpStatus.OK);
        }
    

}
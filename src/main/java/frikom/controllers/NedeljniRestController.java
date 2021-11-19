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

import frikom.jpa. Nedeljni;
import frikom.repos. NedeljniRepository;

@CrossOrigin
@RestController
public class  NedeljniRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NedeljniRepository nedeljniRepository;

    @GetMapping("nedeljni")
    public Collection< Nedeljni> getNedeljni(){
    	
        return nedeljniRepository.findAll();
    }
    
    @GetMapping("nedeljni/{id}")
    public Nedeljni getNedeljni(@PathVariable ("id") Integer id) {
    	
        return nedeljniRepository.getById(id);
    }
    
  
    @PostMapping("nedeljni")
    public ResponseEntity<Nedeljni> insertNedeljni(@RequestBody Nedeljni nedeljni){
        if(!nedeljniRepository.existsById(nedeljni.getIdNedeljni())) {
        	nedeljniRepository.save(nedeljni);
        	
            return new ResponseEntity<Nedeljni>(HttpStatus.OK);
        }
        else {
        	
            return new ResponseEntity<Nedeljni>(HttpStatus.CONFLICT);
        }
    } 
    
    @PutMapping("nedeljni")
    public ResponseEntity<Nedeljni> updateNedeljni(@RequestBody Nedeljni nedeljni){
        if(!nedeljniRepository.existsById(nedeljni.getIdNedeljni())) {
            
            return new ResponseEntity<Nedeljni>(HttpStatus.NO_CONTENT);
        }
        else {
        	nedeljniRepository.save(nedeljni);
        	
            return new ResponseEntity<Nedeljni>(HttpStatus.OK);
        }
    }
    
    @DeleteMapping("nedeljni/{id}")
    public ResponseEntity<Nedeljni> deleteNedeljni(@PathVariable("id") Integer id){
    	if(!nedeljniRepository.existsById(id)) {
            return new ResponseEntity<Nedeljni>(HttpStatus.NO_CONTENT);
        }
    	nedeljniRepository.deleteById(id);
        return new ResponseEntity<Nedeljni>(HttpStatus.OK);
        
    }

}
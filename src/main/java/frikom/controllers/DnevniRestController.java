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

import frikom.jpa. Dnevni;
import frikom.repos. DnevniRepository;

@CrossOrigin
@RestController
public class  DnevniRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DnevniRepository dnevniRepository;

    @GetMapping("dnevni")
    public Collection< Dnevni> getDnevni(){
    	
        return dnevniRepository.findAll();
    }
    
    @GetMapping("dnevni/{id}")
    public Dnevni getDnevni(@PathVariable ("id") Integer id) {
    	
        return dnevniRepository.getById(id);
    }
    
  
    @PostMapping("dnevni")
    public ResponseEntity<Dnevni> insertDnevni(@RequestBody Dnevni dnevni){
        if(!dnevniRepository.existsById(dnevni.getIdDnevni())) {
        	dnevniRepository.save(dnevni);
        	
            return new ResponseEntity<Dnevni>(HttpStatus.OK);
        }
        else {
        	
            return new ResponseEntity<Dnevni>(HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("dnevni")
    public ResponseEntity<Dnevni> updateDnevni(@RequestBody Dnevni dnevni){
        if(!dnevniRepository.existsById(dnevni.getIdDnevni())) {
            
            return new ResponseEntity<Dnevni>(HttpStatus.NO_CONTENT);
        }
        else {
        	dnevniRepository.save(dnevni);
        	
            return new ResponseEntity<Dnevni>(HttpStatus.OK);
        }
    }
    
    @DeleteMapping("dnevni/{id}")
    public ResponseEntity<Dnevni> deleteDnevni(@PathVariable("id") Integer id){
    	if(!dnevniRepository.existsById(id)) {
            return new ResponseEntity<Dnevni>(HttpStatus.NO_CONTENT);
        }
    	else {
            jdbcTemplate.execute("delete from Dnevni where ID_Dnevni = " + id);
            dnevniRepository.deleteById(id);
            
            return new ResponseEntity<Dnevni>(HttpStatus.OK);
        }
    }

}
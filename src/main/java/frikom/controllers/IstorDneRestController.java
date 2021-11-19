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

import frikom.jpa. IstorDne;
import frikom.repos. IstorDneRepository;
 
@CrossOrigin
@RestController
public class  IstorDneRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IstorDneRepository istorDneRepository;

    @GetMapping("istorDne")
    public Collection< IstorDne> getIstorDne(){
    	
        return istorDneRepository.findAll();
    }
    
    @GetMapping("istorDne/{id}")
    public IstorDne getIstorDne(@PathVariable ("id") Integer id) {
    	
        return istorDneRepository.getById(id);
    }
    
  
    @PostMapping("istorDne")
    public ResponseEntity<IstorDne> insertIstorDne(@RequestBody IstorDne istorDne){
        if(!istorDneRepository.existsById(istorDne.getIdIstorDne())) {
        	istorDneRepository.save(istorDne);
        	
            return new ResponseEntity<IstorDne>(HttpStatus.OK);
        }
        else {
        	
            return new ResponseEntity<IstorDne>(HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("istorDne")
    public ResponseEntity<IstorDne> updateIstorDne(@RequestBody IstorDne istorDne){
        if(!istorDneRepository.existsById(istorDne.getIdIstorDne())) {
            
            return new ResponseEntity<IstorDne>(HttpStatus.NO_CONTENT);
        }
        else {
        	istorDneRepository.save(istorDne);
        	
            return new ResponseEntity<IstorDne>(HttpStatus.OK);
        }
    }
    
    @DeleteMapping("istorDne/{id}")
    public ResponseEntity<IstorDne> deleteIstorDne(@PathVariable("id") Integer id){
    	if(!istorDneRepository.existsById(id)) {
            return new ResponseEntity<IstorDne>(HttpStatus.NO_CONTENT);
        }
    	istorDneRepository.deleteById(id);
            return new ResponseEntity<IstorDne>(HttpStatus.OK);
        
    }

}
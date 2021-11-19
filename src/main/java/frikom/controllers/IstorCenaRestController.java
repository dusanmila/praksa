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

import frikom.jpa. IstorCena;
import frikom.repos. IstorCenaRepository;
 
@CrossOrigin
@RestController
public class  IstorCenaRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IstorCenaRepository istorCenaRepository;

    @GetMapping("istorCena")
    public Collection< IstorCena> getIstorCena(){
    	
        return istorCenaRepository.findAll();
    }
    
    @GetMapping("istorCena/{id}")
    public IstorCena getIstorCena(@PathVariable ("id") Integer id) {
    	
        return istorCenaRepository.getById(id);
    }
    
  
    @PostMapping("istorCena")
    public ResponseEntity<IstorCena> insertIstorCena(@RequestBody IstorCena istorCena){
        if(!istorCenaRepository.existsById(istorCena.getIdIstorCena())) {
        	istorCenaRepository.save(istorCena);
        	
            return new ResponseEntity<IstorCena>(HttpStatus.OK);
        }
        else {
        	
            return new ResponseEntity<IstorCena>(HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("istorCena")
    public ResponseEntity<IstorCena> updateIstorCena(@RequestBody IstorCena istorCena){
        if(!istorCenaRepository.existsById(istorCena.getIdIstorCena())) {
            
            return new ResponseEntity<IstorCena>(HttpStatus.NO_CONTENT);
        }
        else {
        	istorCenaRepository.save(istorCena);
        	
            return new ResponseEntity<IstorCena>(HttpStatus.OK);
        }
    }
    
    @DeleteMapping("istorCena/{id}")
    public ResponseEntity<IstorCena> deleteIstorCena(@PathVariable("id") Integer id){
    	if(!istorCenaRepository.existsById(id)) {
            return new ResponseEntity<IstorCena>(HttpStatus.NO_CONTENT);
        }
    	istorCenaRepository.deleteById(id);
            return new ResponseEntity<IstorCena>(HttpStatus.OK);
        
    }

}
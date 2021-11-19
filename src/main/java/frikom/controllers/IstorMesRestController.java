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

import frikom.jpa. IstorMes;
import frikom.repos. IstorMesRepository;
 
@CrossOrigin
@RestController
public class  IstorMesRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IstorMesRepository istorMesRepository;

    @GetMapping("istorMes")
    public Collection< IstorMes> getIstorMes(){
    	
        return istorMesRepository.findAll();
    }
    
    @GetMapping("istorMes/{id}")
    public IstorMes getIstorMes(@PathVariable ("id") Integer id) {
    	
        return istorMesRepository.getById(id);
    }
    
  
    @PostMapping("istorMes")
    public ResponseEntity<IstorMes> insertIstorMes(@RequestBody IstorMes istorMes){
        if(!istorMesRepository.existsById(istorMes.getIdIstorMes())) {
        	istorMesRepository.save(istorMes);
        	
            return new ResponseEntity<IstorMes>(HttpStatus.OK);
        }
        else {
        	
            return new ResponseEntity<IstorMes>(HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("istorMes")
    public ResponseEntity<IstorMes> updateIstorMes(@RequestBody IstorMes istorMes){
        if(!istorMesRepository.existsById(istorMes.getIdIstorMes())) {
            
            return new ResponseEntity<IstorMes>(HttpStatus.NO_CONTENT);
        }
        else {
        	istorMesRepository.save(istorMes);
        	
            return new ResponseEntity<IstorMes>(HttpStatus.OK);
        }
    }
    
    @DeleteMapping("istorMes/{id}")
    public ResponseEntity<IstorMes> deleteIstorMes(@PathVariable("id") Integer id){
    	if(!istorMesRepository.existsById(id)) {
            return new ResponseEntity<IstorMes>(HttpStatus.NO_CONTENT);
        }
    	istorMesRepository.deleteById(id);
            return new ResponseEntity<IstorMes>(HttpStatus.OK);
        
    }

}
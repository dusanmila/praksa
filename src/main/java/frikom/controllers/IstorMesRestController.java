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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 
@CrossOrigin
@RestController
@Api(tags = "Monthly report history REST controller")
public class  IstorMesRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IstorMesRepository istorMesRepository;

    @GetMapping("istorMes")
	@ApiOperation(value = "Returns all monthly report histories")
    public Collection< IstorMes> getIstorMes(){
    	
        return istorMesRepository.findAll();
    }
    
    @GetMapping("istorMes/{id}")
	@ApiOperation(value = "Returns a monthly report history by id")
    public IstorMes getIstorMes(@PathVariable ("id") Integer id) {
    	
        return istorMesRepository.getById(id);
    }
    
  
    @PostMapping("istorMes")
	@ApiOperation(value = "Inserts a new monthly report history")
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
	@ApiOperation(value = "Updates an existing monthly report history")
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
	@ApiOperation(value = "Deletes an existing monthly report history")
    public ResponseEntity<IstorMes> deleteIstorMes(@PathVariable("id") Integer id){
    	if(!istorMesRepository.existsById(id)) {
            return new ResponseEntity<IstorMes>(HttpStatus.NO_CONTENT);
        }
    	istorMesRepository.deleteById(id);
            return new ResponseEntity<IstorMes>(HttpStatus.OK);
        
    }

}
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

import frikom.jpa. Mesecni;
import frikom.repos. MesecniRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "Monthly report REST controller")
public class  MesecniRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MesecniRepository mesecniRepository;

    @GetMapping("mesecni")
	@ApiOperation(value = "Returns all monthly reports")
    public Collection< Mesecni> getMesecni(){
    	
        return mesecniRepository.findAll();
    }
    
    @GetMapping("mesecni/{id}")
	@ApiOperation(value = "Returns a monthly report by id")
    public Mesecni getMesecni(@PathVariable ("id") Integer id) {
    	
        return mesecniRepository.getById(id);
    }
    
  
    @PostMapping("mesecni")
	@ApiOperation(value = "Inserts a new monthly report")
    public ResponseEntity<Mesecni> insertMesecni(@RequestBody Mesecni mesecni){
        if(!mesecniRepository.existsById(mesecni.getIdMesecni())) {
        	mesecniRepository.save(mesecni);
        	
            return new ResponseEntity<Mesecni>(HttpStatus.OK);
        }
        else {
        	
            return new ResponseEntity<Mesecni>(HttpStatus.CONFLICT);
        }
        
    }
    
    @PutMapping("mesecni")
	@ApiOperation(value = "Updates an existing monthly report")
    public ResponseEntity<Mesecni> updateMesecni(@RequestBody Mesecni mesecni){
        if(!mesecniRepository.existsById(mesecni.getIdMesecni())) {
            
            return new ResponseEntity<Mesecni>(HttpStatus.NO_CONTENT);
        }
        else {
        	mesecniRepository.save(mesecni);
        	
            return new ResponseEntity<Mesecni>(HttpStatus.OK);
        }
    }
    
    @DeleteMapping("mesecni/{id}")
	@ApiOperation(value = "Deletes an existing monthly report")
    public ResponseEntity<Mesecni> deleteMesecni(@PathVariable("id") Integer id){
    	if(!mesecniRepository.existsById(id)) {
            return new ResponseEntity<Mesecni>(HttpStatus.NO_CONTENT);
        }
    	mesecniRepository.deleteById(id);
        return new ResponseEntity<Mesecni>(HttpStatus.OK);
        
    }

}
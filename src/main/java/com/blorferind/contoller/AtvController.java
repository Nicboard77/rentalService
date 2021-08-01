package com.blorferind.contoller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blorferind.repository.AtvRepository;
import com.blorferind.entities.Atv;

@Transactional
@RestController
@RequestMapping(value = "/rest/atv")
public class AtvController {
  @Autowired
  AtvRepository atvRepository;
  @GetMapping(value = "/all")
  public List<Atv> getAll() {
    return atvRepository.findAll();
  }
  @PostMapping(value = "/load")
  public List<Atv> persist(@RequestBody final Atv atv) {
    atvRepository.save(atv);
    return atvRepository.findAll();
  }
  
  @PostMapping(value = "/createNewAtv")
  public ResponseEntity<Atv> createNewAtv(@RequestBody Atv newAtv) {
    Atv atv = atvRepository.save(newAtv);
    return new ResponseEntity<>(atv , HttpStatus.CREATED);
  }
  @DeleteMapping(value = "/deleteAtvById")
  public ResponseEntity<Integer> deleteAtvById(Integer id) {
    atvRepository.deleteById(id);
    return new ResponseEntity<>(id,HttpStatus.OK);
  }
  @PutMapping(value = "/updateAtvById/{id}")
  public ResponseEntity<Integer> updateCarById(@RequestBody Atv atv,
      @PathVariable Integer id) {
    Optional<Atv> atvOptional = atvRepository.findById(id);
    if (!atvOptional.isPresent())
      return ResponseEntity.notFound().build();
    atv.setAtvId(id);
    atvRepository.save(atv);
    return ResponseEntity.noContent().build();
      
    
    
  }
  

}

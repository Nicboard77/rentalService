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
import com.blorferind.entities.Rental;
import com.blorferind.repository.RentalRepository;

@Transactional
@RestController
@RequestMapping(value = "/rest/rental")
public class RentalController {
  @Autowired
  RentalRepository rentalRepository;
  @GetMapping(value = "/all")
  public List<Rental> getAll() {
    return rentalRepository.findAll();
  }
  @PostMapping(value = "/load")
  public List<Rental> persist(@RequestBody final Rental rental) {
    rentalRepository.save(rental);
    return rentalRepository.findAll();
  }
  @PostMapping(value = "/createNewRental")
  public ResponseEntity<Rental> createNewRental(@RequestBody Rental newRental){
    Rental rental = rentalRepository.save(newRental);
    return new ResponseEntity<>(rental, HttpStatus.CREATED);
  }
  
  @DeleteMapping(value = "/deleteRentalById")
  public ResponseEntity<Integer> deleteRentalById(Integer id) {
    rentalRepository.deleteById(id);
    return new ResponseEntity<>(id, HttpStatus.OK);
  }

@PutMapping(value = "/updateRentalById/{id}")
public ResponseEntity<Integer> updateCarById(@RequestBody Rental rental,
    @PathVariable Integer id) {
  Optional<Rental> raftOptional = rentalRepository.findById(id);
  if (!raftOptional.isPresent())
    return ResponseEntity.notFound().build();
  rental.setRentalId(id);
  rentalRepository.save(rental);
  return ResponseEntity.noContent().build();
    
  
  
}

  

}

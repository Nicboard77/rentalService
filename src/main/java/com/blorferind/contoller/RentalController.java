package com.blorferind.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
  public List<Rental> persist(@RequestBody final Rental rental) {
    rentalRepository.save(rental);
    return rentalRepository.findAll();
  }
  

}

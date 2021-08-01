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
import com.blorferind.entities.Car;
import com.blorferind.repository.CarRepository;

@Transactional
@RestController
@RequestMapping(value = "/rest/car")
public class CarController {
  
  @Autowired
  CarRepository carRepository;
  @GetMapping(value = "/all")
  public List<Car> getAll() {
    return carRepository.findAll();
  }
  
  @PostMapping(value = "/load")
  public List<Car> persist(@RequestBody final Car car) {
    carRepository.save(car);
    return carRepository.findAll();
  }
  @PostMapping(value = "/createNewCar")
  public ResponseEntity<Car> createNewCar(@RequestBody Car newCar) {
    Car car = carRepository.save(newCar);
    return new ResponseEntity<>(car, HttpStatus.CREATED);
  }
  @DeleteMapping(value = "/deleteCarById")
  public ResponseEntity<Integer> deleteCarById(Integer id) {
    carRepository.deleteById(id);
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
  
  @PutMapping(value = "/updateCarById/{id}")
  public ResponseEntity<Object> deleteCarById(@RequestBody Car car,
      @PathVariable Integer id) {
    Optional<Car> carOptional = carRepository.findById(id);
    if (!carOptional.isPresent()) 
      return ResponseEntity.notFound().build();
    car.setCarId(id);
    carRepository.save(car);
    return ResponseEntity.noContent().build();
    
  }

}

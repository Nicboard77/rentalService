package com.blorferind.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
  
  public List<Car> persist(@RequestBody final Car car) {
    carRepository.save(car);
    return carRepository.findAll();
  }

}

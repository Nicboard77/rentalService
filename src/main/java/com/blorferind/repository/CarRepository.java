package com.blorferind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blorferind.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

}

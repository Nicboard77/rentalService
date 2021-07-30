package com.blorferind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blorferind.entities.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer>{

}

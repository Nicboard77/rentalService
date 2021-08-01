package com.blorferind.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "car_id")
  private int carId;
  @Column(name = "car_model")
  private String carModel;
  @Column(name = "car_miles")
  private int carMiles;
  @Column(name = "car_licence_plate")
  private String carLicencePlate;
  @Column(name = "car_color")
  private String carColor;
  @Column(name = "4_wheel_drive")
  private boolean fourWheelDrive;
  @Column(name = "rental_cost")
  private int rentalCost;
  @Column(name = "car_year")
  private int carYear;

}

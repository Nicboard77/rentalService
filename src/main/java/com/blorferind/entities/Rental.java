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
public class Rental {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "")
  private int rentalId;
  @Column(name = "")
  private int totalRentalCost;
  @Column(name = "")
  private int customerId;
  @Column(name = "")
  private int carId;
  @Column(name = "")
  private int rentalLengthInDays;
  @Column(name = "")
  private String startDate;
  @Column(name = "")
  private String endDate;
}

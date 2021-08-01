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
  private Integer rentalId;
  @Column(name = "")
  private Integer totalRentalCost;
  @Column(name = "")
  private Integer customerId;
  @Column(name = "", nullable = true)
  private Integer carId;
  @Column(name = "", nullable = true)
  private Integer atvId;
  @Column(name = "", nullable = true)
  private Integer raftId;
  @Column(name = "")
  private Integer rentalLengthInDays;
  @Column(name = "")
  private String startDate;
  @Column(name = "")
  private String endDate;
}

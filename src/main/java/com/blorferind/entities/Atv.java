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
public class Atv {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "atv_id")
  private int atvId;
  @Column(name = "atv_model")
  private String atvModel;
  @Column(name = "atv_miles")
  private int atvMiles;
  @Column(name = "rental_cost")
  private int rentalCost;
  

}

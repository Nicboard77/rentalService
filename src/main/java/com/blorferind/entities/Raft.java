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
public class Raft {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "raft_id")
  private int raftId;
  @Column(name = "raft_model")
  private String raftModel;
  @Column(name = "rental_cost")
  private int rentalCost;
  @Column(name = "raft_size")
  private String raftSize;

}

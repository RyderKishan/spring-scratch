package com.globeking.springserver.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "gk_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String firstName;
  @Column(nullable = false, unique = true, updatable = false)
  private String secId;
  private String lastName;
  private LocalDateTime dob;
}
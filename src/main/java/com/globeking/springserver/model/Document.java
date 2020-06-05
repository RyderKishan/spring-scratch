package com.globeking.springserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gk_document")
public class Document {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String docId;
  @OneToOne
  @JoinColumn(name = "docId", insertable = false, updatable = false)
  private DocumentMetaData documentMetaData;
  private String docType;
}

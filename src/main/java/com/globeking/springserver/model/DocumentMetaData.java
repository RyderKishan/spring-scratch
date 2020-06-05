package com.globeking.springserver.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "gk_document_meta_data")
public class DocumentMetaData {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String docId;
  private String docName;
  private String docSize;
}

package com.globeking.springserver.repository;

import com.globeking.springserver.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
  Document getDocumentMetaDataByDocId(String docId);
}

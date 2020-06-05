package com.globeking.springserver.service;

import com.globeking.springserver.model.Document;
import com.globeking.springserver.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
  private final DocumentRepository documentRepository;

  @Autowired
  public DocumentService(DocumentRepository documentRepository) {
    this.documentRepository = documentRepository;
  }

  public Document addDoc(Document documentMetaData) {
    return documentRepository.save(documentMetaData);
  }

  public Document getDoc(String docId) {
    return documentRepository.getDocumentMetaDataByDocId(docId);
  }
}

package com.globeking.springserver.controller;

import java.util.Optional;

import com.globeking.springserver.exception.BadRequestException;
import com.globeking.springserver.exception.NoContentException;
import com.globeking.springserver.model.Document;
import com.globeking.springserver.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/doc")
public class DocumentController {
  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);

  private final DocumentService documentService;

  @Autowired
  public DocumentController(DocumentService documentService) {
    this.documentService = documentService;
  }

  @GetMapping("/getdoc/{docId}")
  public ResponseEntity<Document> getDocByDocId(@PathVariable String docId) {
    LOGGER.info("getDocByDocId :: Triggered");
    Optional.ofNullable(docId).orElseThrow(() -> new BadRequestException("msg", this.getClass().getName()));
    Document documentMetaData = documentService.getDoc(docId);
    Optional.ofNullable(documentMetaData).orElseThrow(() -> new NoContentException("Document not found", this.getClass().getName()));
    return new ResponseEntity<>(documentMetaData, HttpStatus.OK);
  }

  @PostMapping("/adddoc")
  public ResponseEntity<Document> addDoc(@RequestBody Document documentMetaData) {
    LOGGER.info("addDoc :: Triggered");
    Document savedDocument = documentService.addDoc(documentMetaData);
    return new ResponseEntity<>(savedDocument, HttpStatus.OK);
  }
//
//  @DeleteMapping("/deleteuser/{secId}")
//  public ResponseEntity<Boolean> deleteUser(@PathVariable String secId) {
//    LOGGER.info("deleteuser :: Triggered");
//    userService.deleteUser(secId);
//    return new ResponseEntity<>(true, HttpStatus.OK);
//  }
}
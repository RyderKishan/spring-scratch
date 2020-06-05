package com.globeking.springserver.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.globeking.springserver.model.Document;
import com.globeking.springserver.model.Sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class RestApiController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RestApiController.class);

  @GetMapping("/ping")
  public ResponseEntity<LocalDateTime> ping() {
    LOGGER.info("ping :: Triggered");
    return new ResponseEntity<>(LocalDateTime.now(), HttpStatus.OK);
  }

  // Remove all the things that follows this

  @GetMapping("/samplegetsuccess")
  public ResponseEntity<List<String>> samplegetsuccess() {
    LOGGER.info("samplegetsuccess :: Triggered");
    List<String> names = new ArrayList<>();
    names.add("Kishan");
    names.add("Raj");
    names.add("Supreme");
    return new ResponseEntity<>(names, HttpStatus.OK);
  }

  @GetMapping("/sampleget")
  public ResponseEntity<List<String>> sampleget() {
    LOGGER.info("sampleget :: Triggered");
    List<String> names = new ArrayList<>();
    names.add("Kishan");
    names.add("Raj");
    names.add("Supreme");
    return new ResponseEntity<>(names, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @GetMapping("/samplegetbad")
  public ResponseEntity<List<String>> samplegetbad() {
    LOGGER.info("sampleget :: Triggered");
    List<String> names = new ArrayList<>();
    names.add("Kishan");
    names.add("Raj");
    names.add("Supreme");
    return new ResponseEntity<>(names, HttpStatus.BAD_REQUEST);
  }

  @PostMapping("/samplepost")
  public ResponseEntity<Document> addDoc(@RequestBody Sample sample) {
    Document document = new Document();
    document.setDocId("oiskj3knzsisi92");
    document.setDocType("SUCCESS");
    if (sample.getName().isEmpty()) {
      document.setDocType("FAILED");
      return new ResponseEntity<>(document, HttpStatus.BAD_REQUEST);
    }
    LOGGER.info("addDoc :: Triggered");
    document.setId(12728);
    return new ResponseEntity<>(document, HttpStatus.OK);
  }

}
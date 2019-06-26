package com.globeking.springserver.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
package com.globeking.springserver.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestApiController {
  @GetMapping("/ping")
  public ResponseEntity<String> ping() {
    return new ResponseEntity<>(LocalDateTime.now().toString(), HttpStatus.OK);
  }
}
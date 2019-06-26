package com.globeking.springserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/user")
public class UserController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RestApiController.class);

  @GetMapping("/add")
  public ResponseEntity<String> addUser() {
    LOGGER.info("addUser :: Triggered");
    return new ResponseEntity<>("User Will be Added", HttpStatus.OK);
  }
}
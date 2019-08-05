package com.globeking.springserver.controller;

import java.util.Optional;

import com.globeking.springserver.exception.BadRequestException;
import com.globeking.springserver.exception.NoContentException;
import com.globeking.springserver.model.User;
import com.globeking.springserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/user")
public class UserController {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/getuser/{secId}")
  public ResponseEntity<User> getUserBySecId(@PathVariable String secId) {
    LOGGER.info("addUser :: Triggered");
    Optional.ofNullable(secId).orElseThrow(() -> new BadRequestException("msg", this.getClass().getName()));
    User user = userService.getUser(secId);
    Optional.ofNullable(user).orElseThrow(() -> new NoContentException("User not found", this.getClass().getName()));
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PostMapping("/adduser")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    LOGGER.info("addUser :: Triggered");
    User savedUser = userService.addUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.OK);
  }

  @DeleteMapping("/deleteuser/{secId}")
  public ResponseEntity<Boolean> deleteUser(@PathVariable String secId) {
    LOGGER.info("deleteuser :: Triggered");
    userService.deleteUser(secId);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }
}
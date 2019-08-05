package com.globeking.springserver.service;

import com.globeking.springserver.model.User;
import com.globeking.springserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User addUser(User user) {
    return userRepository.save(user);
  }

  public User getUser(String id) {
    return userRepository.getUserBySecId(id);
  }

  public Void deleteUser(String id) {
    User toDelete = userRepository.getUserBySecId(id);
    userRepository.deleteById(toDelete.getId());
    return null;
  }
}

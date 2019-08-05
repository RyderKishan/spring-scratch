package com.globeking.springserver.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private final String errorMessage;
  private final String className;

  public CustomException(String errorMessage, String className) {
    super();
    this.errorMessage = errorMessage;
    this.className = className;
  }
}

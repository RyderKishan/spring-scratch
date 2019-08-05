package com.globeking.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentException extends CustomException {
  private static final long serialVersionUID = 1L;

  public NoContentException(String errorMessage, String className) {
    super(errorMessage, className);
  }
}

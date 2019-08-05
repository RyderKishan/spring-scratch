package com.globeking.springserver.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetail {
  private final LocalDateTime timestamp;
  private final String className;
  private final String errorMessage;
  private final String details;
  private final String code;

  public ErrorDetail(LocalDateTime timestamp, String className, String errorMessage, String details, String code) {
    this.timestamp = timestamp;
    this.className = className;
    this.errorMessage = errorMessage;
    this.details = details;
    this.code = code;
  }
}

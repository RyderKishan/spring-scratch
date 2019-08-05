package com.globeking.springserver.exception;

import com.globeking.springserver.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(BadRequestException.class)
  public final ResponseEntity<ErrorDetail> handleBadRequestException(BadRequestException exception, WebRequest request) {
    return errorResponse(HttpStatus.BAD_REQUEST, exception, request);
  }@ExceptionHandler(NoContentException.class)
  public final ResponseEntity<ErrorDetail> handleNoContentException(NoContentException exception, WebRequest request) {
    return errorResponse(HttpStatus.NO_CONTENT, exception, request);
  }

  private ResponseEntity<ErrorDetail> errorResponse(HttpStatus httpStatus, CustomException exception,
                                                    WebRequest webRequest) {

    ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(), exception.getClassName(), exception.getMessage(), webRequest.getDescription(false),
            httpStatus.toString());
    return new ResponseEntity<>(errorDetail, httpStatus);
  }
}

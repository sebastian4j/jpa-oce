package com.example.sebastian.demo.sb.jpa;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionMapper {

  @ExceptionHandler(value = {ConstraintViolationException.class})
  @ResponseStatus(HttpStatus.CONFLICT)
  @ResponseBody
  public ErrorInfo handleConflict(ConstraintViolationException ex, WebRequest req) {
    return new ErrorInfo("Identificador de registro duplicado", ex);
  }
}

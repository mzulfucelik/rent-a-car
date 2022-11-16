package com.mzulfucelik.rentacar.exception;

import org.springframework.http.HttpStatus;

public class InvalidTokenException extends Exception {

  private static final long serialVersionUID = 1L;
  private HttpStatus status;
  private String message;

  public InvalidTokenException() {}

  public InvalidTokenException(String message) {
    super(message);
  }
}

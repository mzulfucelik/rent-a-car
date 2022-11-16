package com.mzulfucelik.rentacar.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends Exception {

  private static final long serialVersionUID = 1L;
  private HttpStatus status;
  private String message;

  public UserNotFoundException() {}

  public UserNotFoundException(String message) {
    super(message);
  }
}

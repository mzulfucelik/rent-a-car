package com.mzulfucelik.rentacar.exception;

import org.springframework.http.HttpStatus;

public class DataCannotBeModifiedException extends Exception {

  private static final long serialVersionUID = 1L;
  private HttpStatus status;
  private String message;

  public DataCannotBeModifiedException() {}

  public DataCannotBeModifiedException(String message) {
    super(message);
  }
}

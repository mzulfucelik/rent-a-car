package com.mzulfucelik.rentacar.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class DataNotFoundException extends Exception {

  private static final long serialVersionUID = 1L;
  private HttpStatus status;
  private String message;

  public DataNotFoundException() {}

  public DataNotFoundException(String message) {
    super(message);
  }
}

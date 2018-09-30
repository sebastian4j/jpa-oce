package com.example.sebastian.demo.sb.jpa;

public class ErrorInfo {
  public final String info;
  public final String ex;

  public ErrorInfo(String in, Exception ex) {
    this.info = in;
    this.ex = ex.getLocalizedMessage();
  }
}

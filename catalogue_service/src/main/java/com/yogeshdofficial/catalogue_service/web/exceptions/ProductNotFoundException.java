package com.yogeshdofficial.catalogue_service.web.exceptions;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String message) {
    super(message);
  }

  public static ProductNotFoundException forCode(String code) {

    return new ProductNotFoundException("Product with code " + code + " not found");
  }
}

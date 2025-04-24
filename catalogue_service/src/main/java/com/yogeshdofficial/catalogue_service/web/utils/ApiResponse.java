package com.yogeshdofficial.catalogue_service.web.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApiResponse<T> {
  private T data;
  private String status;
  private String message;
  private boolean error;
  private Object metadata;
}

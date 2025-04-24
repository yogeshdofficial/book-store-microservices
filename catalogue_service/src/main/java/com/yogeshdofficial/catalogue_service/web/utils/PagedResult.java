package com.yogeshdofficial.catalogue_service.web.utils;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagedResult<T> {
  List<T> data;
  long totalElements;
  int pageNumber;
  int totalPages;
  boolean firstPage;
  boolean lastPage;
  boolean hasNext;
  boolean hasPrevious;
}

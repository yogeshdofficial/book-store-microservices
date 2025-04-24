package com.yogeshdofficial.catalogue_service.domain.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
  private String code;
  private String name;
  private String description;
  private String imageUrl;
  private BigDecimal price;
}

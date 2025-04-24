package com.yogeshdofficial.catalogue_service.domain.product;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.yogeshdofficial.catalogue_service.domain.interfaces.MapperInterface;

@Component
class ProductMapper implements MapperInterface<ProductEntity, ProductDto> {
  private final ModelMapper modelMapper;

  ProductMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public ProductDto toDto(ProductEntity productEntity) {
    return modelMapper.map(productEntity, ProductDto.class);
  }

  public ProductEntity toEntity(ProductDto productDto) {
    return modelMapper.map(productDto, ProductEntity.class);
  }
}

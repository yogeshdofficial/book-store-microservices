package com.yogeshdofficial.catalogue_service.domain.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yogeshdofficial.catalogue_service.web.exceptions.ProductNotFoundException;
import com.yogeshdofficial.catalogue_service.web.utils.PagedResult;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
  private final ProductRepo productRepo;
  private final ProductMapper productMapper;

  ProductService(ProductRepo productRepo, ProductMapper productMapper) {
    this.productRepo = productRepo;
    this.productMapper = productMapper;
  }

  public PagedResult<ProductDto> getProducts(Pageable pageable) {
    Page<ProductEntity> products = productRepo.findAll(pageable);
    return new PagedResult<ProductDto>(products.map(productMapper::toDto).toList(), products.getTotalElements(),
        products.getNumber(), products.getTotalPages(), products.isFirst(), products.isLast(), products.hasNext(),
        products.hasPrevious());

  }

  public ProductDto getProduct(String code) {

    ProductEntity productEntity = productRepo.findByCode(code);
    if (productEntity == null) {
      throw ProductNotFoundException.forCode(code);
    } else {
      return productMapper.toDto(productEntity);
    }
  }
}
package com.yogeshdofficial.catalogue_service.web.Product;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogeshdofficial.catalogue_service.domain.product.ProductDto;
import com.yogeshdofficial.catalogue_service.domain.product.ProductService;
import com.yogeshdofficial.catalogue_service.web.utils.PagedResult;

@RestController
@RequestMapping("/api/products")
class ProductController {
  private final ProductService productService;

  ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/")
  ResponseEntity<PagedResult<ProductDto>> getProducts(Pageable pageable) {
    PagedResult<ProductDto> pagedProducts = productService.getProducts(pageable);

    return new ResponseEntity<PagedResult<ProductDto>>(pagedProducts, HttpStatus.OK);
  }

  @GetMapping("/{code}")
  ResponseEntity<ProductDto> getProduct(@PathVariable("code") String code) {
    // var productDto = productService.getProduct(code);
    return new ResponseEntity<ProductDto>(productService.getProduct(code),
        HttpStatus.OK);
  }
}

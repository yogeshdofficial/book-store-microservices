package com.yogeshdofficial.catalogue_service.domain.product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepo extends JpaRepository<ProductEntity, Long> {
  ProductEntity findByCode(String code);
}

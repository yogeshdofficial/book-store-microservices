package com.yogeshdofficial.catalogue_service.domain.interfaces;

public interface MapperInterface<A, B> {
  B toDto(A a);

  A toEntity(B b);
}

package com.example.spokbit.converter;

import java.util.List;

public interface ConverterTopic<E, D> {
    E toEntity(D dto);
    D toDto(E entity);
    List<D> toDto(List<E> entitys);
}

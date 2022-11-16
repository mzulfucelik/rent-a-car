package com.mzulfucelik.rentacar.controller.mapper;

import com.mzulfucelik.rentacar.dto.GenericDTO;
import com.mzulfucelik.rentacar.dto.SimpleDTO;
import com.mzulfucelik.rentacar.model.GenericEntity;

import java.util.List;
import java.util.Set;

public interface GenericMapper<E extends GenericEntity, D extends GenericDTO> {

    D toDTO(E entity);

    List<D> toDTOs(List<E> entities);

    Set<D> toDTOs(Set<E> entities);

    E toEntity(D dto);

    List<E> toEntities(List<D> dtos);

    Set<E> toEntities(Set<D> dtos);

    E toEntityFromSimpleDTO(SimpleDTO dto);

    List<E> toEntitiesFromSimpleDTOs(List<SimpleDTO> dtos);

    Set<E> toEntitiesFromSimpleDTOs(Set<SimpleDTO> dtos);

    SimpleDTO toSimpleDTO(E entity);

    List<SimpleDTO> toSimpleDTOs(List<E> entities);

    Set<SimpleDTO> toSimpleDTOs(Set<E> entities);
}

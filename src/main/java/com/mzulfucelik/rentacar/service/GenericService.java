package com.mzulfucelik.rentacar.service;

import com.mzulfucelik.rentacar.model.GenericEntity;

import java.util.List;
import java.util.Optional;

public interface GenericService<E extends GenericEntity> {

    E save(E entity) throws Exception;

    void delete(E entity) throws Exception;

    void deleteById(Long id) throws Exception;

    Optional<E> getById(Long id) throws Exception;

    List<E> getAll() throws Exception;

    List<E> getAllByIdList(List<Long> ids) throws Exception;

}

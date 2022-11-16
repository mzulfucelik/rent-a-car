package com.mzulfucelik.rentacar.service;

import com.mzulfucelik.rentacar.model.GenericEntity;
import com.mzulfucelik.rentacar.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Transactional(rollbackFor = Throwable.class)
public abstract class AbstractService<E extends GenericEntity> implements GenericService<E> {

    @Autowired
    protected GenericRepository<E> repository;


    @Override
    public E save(E entity) throws Exception {
        if (entity.getId() == null) {
            entity.setCreateDate(LocalDateTime.now());
            entity.setUpdateDate(LocalDateTime.now());
        } else {
            entity.setUpdateDate(LocalDateTime.now());
        }
        return repository.save(entity);
    }


    @Override
    public void delete(E entity) throws Exception {
        repository.delete(entity);
    }

    @Override
    public Optional<E> getById(Long id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public List<E> getAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public List<E> getAllByIdList(List<Long> ids) throws Exception {
        Iterable<E> eIterable = repository.findAllById(ids);
        List<E> entities = new ArrayList<>();
        Iterator<E> eIterator = eIterable.iterator();
        while (eIterator.hasNext()) {
            entities.add(eIterator.next());
        }
        return entities;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        repository.deleteById(id);
    }
}

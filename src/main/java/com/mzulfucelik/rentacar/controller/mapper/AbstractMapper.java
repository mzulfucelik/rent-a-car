package com.mzulfucelik.rentacar.controller.mapper;

import com.mzulfucelik.rentacar.dto.GenericDTO;
import com.mzulfucelik.rentacar.dto.SimpleDTO;
import com.mzulfucelik.rentacar.model.GenericEntity;
import org.springframework.core.GenericTypeResolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractMapper<E extends GenericEntity, D extends GenericDTO>
        implements GenericMapper<E, D> {
    protected abstract void fillDTO(D dto, E entity);

    protected abstract void fillEntity(E entity, D dto);

    protected abstract String getLabel(E entity);

    @Override
    public D toDTO(E entity) {
        if (entity == null) return null;
        D dto = getDTOInstance();
        dto.setId(entity.getId());
        dto.setCreateDate(entity.getCreateDate());
        dto.setUpdateDate(entity.getUpdateDate());
        fillDTO(dto, entity);
        return dto;
    }

    @Override
    public E toEntity(D dto) {
        if (dto == null) return null;
        E entity = getEntityInstance();
        entity.setId(dto.getId());
        entity.setCreateDate(dto.getCreateDate());
        entity.setUpdateDate(dto.getUpdateDate());
        fillEntity(entity, dto);
        return entity;
    }

    @Override
    public SimpleDTO toSimpleDTO(E entity) {
        if (entity == null) return null;
        SimpleDTO dto = new SimpleDTO();
        dto.setId(entity.getId());
        dto.setName(getLabel(entity));
        dto.setCreateDate(entity.getCreateDate());
        dto.setUpdateDate(entity.getUpdateDate());
        return dto;
    }

    @Override
    public List<SimpleDTO> toSimpleDTOs(List<E> entities) {
        if (entities == null) return null;
        List<SimpleDTO> dtos = new ArrayList<>();
        for (E entity : entities) {
            SimpleDTO dto = toSimpleDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Set<SimpleDTO> toSimpleDTOs(Set<E> entities) {
        if (entities == null) return null;
        Set<SimpleDTO> dtos = new HashSet<>();
        for (E entity : entities) {
            SimpleDTO dto = toSimpleDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public E toEntityFromSimpleDTO(SimpleDTO dto) {
        if (dto == null) return null;
        E entity = getEntityInstance();
        entity.setIsSimpleEntity(Boolean.TRUE);
        entity.setId(dto.getId());
        entity.setCreateDate(dto.getCreateDate());
        entity.setUpdateDate(dto.getUpdateDate());
        return entity;
    }

    @Override
    public List<E> toEntitiesFromSimpleDTOs(List<SimpleDTO> dtos) {
        if (dtos == null) return null;
        List<E> entities = new ArrayList<>();
        for (SimpleDTO dto : dtos) {
            E entity = toEntityFromSimpleDTO(dto);
            entities.add(entity);
        }
        return entities;
    }

    @Override
    public Set<E> toEntitiesFromSimpleDTOs(Set<SimpleDTO> dtos) {
        if (dtos == null) return null;
        Set<E> entities = new HashSet<>();
        for (SimpleDTO dto : dtos) {
            E entity = toEntityFromSimpleDTO(dto);
            entities.add(entity);
        }
        return entities;
    }

    @Override
    public List<E> toEntities(List<D> dtos) {
        if (dtos == null) return null;
        List<E> entities = new ArrayList<>();
        for (D dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }

    @Override
    public Set<E> toEntities(Set<D> dtos) {
        if (dtos == null) return null;
        Set<E> entities = new HashSet<>();
        for (D dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }

    @Override
    public List<D> toDTOs(List<E> entities) {
        if (entities == null) return null;
        List<D> dtos = new ArrayList<>();
        for (E entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    @Override
    public Set<D> toDTOs(Set<E> entities) {
        if (entities == null) return null;
        Set<D> dtos = new HashSet<>();
        for (E entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    @SuppressWarnings("unchecked")
    protected Class<E> getSourceTypeEntity() {
        Class<?>[] typeArgs = GenericTypeResolver.resolveTypeArguments(getClass(), GenericMapper.class);
        return (Class<E>) typeArgs[0];
    }

    private E getEntityInstance() {
        Class<E> sourceType = getSourceTypeEntity();
        E entity = null;
        try {
            entity = sourceType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return entity;
    }

    @SuppressWarnings("unchecked")
    private Class<D> getSourceTypeDTO() {
        Class<?>[] typeArgs = GenericTypeResolver.resolveTypeArguments(getClass(), GenericMapper.class);
        return (Class<D>) typeArgs[1];
    }

    private D getDTOInstance() {
        Class<D> sourceType = getSourceTypeDTO();
        D entity = null;
        try {
            entity = sourceType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return entity;
    }
}

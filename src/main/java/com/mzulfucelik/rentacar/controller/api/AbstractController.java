package com.mzulfucelik.rentacar.controller.api;

import com.mzulfucelik.rentacar.common.repsonse.CustomResponse;
import com.mzulfucelik.rentacar.controller.mapper.GenericMapper;
import com.mzulfucelik.rentacar.dto.GenericDTO;
import com.mzulfucelik.rentacar.model.GenericEntity;
import com.mzulfucelik.rentacar.service.GenericService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor

public abstract class AbstractController<E extends GenericEntity, D extends GenericDTO> {
    @Autowired
    protected GenericService<E> service;
    @Autowired
    protected GenericMapper<E, D> mapper;

    @GetMapping("/{id}")
    public ResponseEntity<D> get(@PathVariable Long id) throws Exception {
        Optional<E> entity = service.getById(id);
        return new ResponseEntity<D>(mapper.toDTO(entity.get()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<D>> get() throws Exception {
        List<E> entities = service.getAll();
        return new ResponseEntity<List<D>>(mapper.toDTOs(entities), HttpStatus.OK);
    }

    @GetMapping("/getByIds")
    public ResponseEntity<List<D>> getAllByIds(@RequestParam("ids") List<Long> ids)
            throws Exception {
        List<E> entities = service.getAllByIdList(ids);
        return new ResponseEntity<List<D>>(mapper.toDTOs(entities), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<D> save(@RequestBody D dto) throws Exception {
        E entity = service.save(mapper.toEntity(dto));
        return new ResponseEntity<D>(mapper.toDTO(entity), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody D dto) throws Exception {
        Optional<E> entity = service.getById((dto.getId()));
        if (entity == null) {
            return new ResponseEntity<>(
                    new CustomResponse(HttpStatus.NOT_FOUND.toString()), HttpStatus.NOT_FOUND);
        }
        E savedEntity = service.save(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDTO(savedEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteById(@PathVariable Long id) throws Exception {
        Optional<E> entity = service.getById(id);
        if (entity == null) {
            return new ResponseEntity<>(
                    new CustomResponse(HttpStatus.NOT_FOUND.toString()), HttpStatus.NOT_FOUND);
        }
        service.delete(entity.get());
        return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.toString()), HttpStatus.OK);
    }
}

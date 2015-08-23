package com.jrtest.vaka.controller;

import com.jrtest.vaka.dao.Page;
import com.jrtest.vaka.model.BaseEntity;
import com.jrtest.vaka.service.CrudService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Iaroslav
 * @since 22.12.2014 21:50
 */
@RestController
public abstract class BaseCrudController<Entity extends BaseEntity> implements CrudController<Entity> {

    public abstract CrudService<Entity> getService();

    @Override
    public ResponseEntity<Entity> create(@RequestBody Entity entity) {
        return new ResponseEntity<>(getService().create(entity));
    }

    @Override
    public ResponseEntity<Entity> read(@PathVariable("id") int id) {
        return new ResponseEntity<>(getService().read(id));
    }

    @Override
    public ResponseEntity<List<Entity>> readPage(@RequestParam(value = "page", defaultValue = "100") int page, @RequestParam(value = "rows", defaultValue = "20") int rows) {
        Page<Entity> res = getService().readPage(page, rows);
        return new ResponseEntity<>(res.getContent(), res.getLength());
    }

    @Override
    public ResponseEntity<Entity> update(@PathVariable("id") int id, @RequestBody Entity entity) {
        return new ResponseEntity<>(getService().update(id, entity));
    }

    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return new ResponseEntity<>(getService().delete(id));
    }
}

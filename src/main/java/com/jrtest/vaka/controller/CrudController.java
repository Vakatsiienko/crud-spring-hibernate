package com.jrtest.vaka.controller;

import com.jrtest.vaka.model.BaseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * @author Iaroslav
 * @since 22.12.2014 21:38
 */
@RestController
public interface CrudController<Entity extends BaseEntity> {
    @RequestMapping(method = POST)
    ResponseEntity<Entity> create(Entity entity);

    @RequestMapping("{id}")
    ResponseEntity<Entity> read(@PathVariable("id") int id);

    @RequestMapping(value = "{id}", method = PUT)
    ResponseEntity<Entity> update(@PathVariable("id") int id, @RequestBody Entity entity);

    @RequestMapping(value = "{id}", method = DELETE)
    ResponseEntity<Boolean> delete(int id);
}

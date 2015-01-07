package com.jrtest.vaka.controller;

import com.jrtest.vaka.model.BaseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping
    ResponseEntity<List<Entity>> readPage(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "rows", defaultValue = "20") int rows);

    @RequestMapping(value = "{id}", method = PUT)
    ResponseEntity<Entity> update(@PathVariable("id") int id, @RequestBody Entity entity);

    @RequestMapping(value = "{id}", method = DELETE)
    ResponseEntity<Boolean> delete(@PathVariable("id") int id);
}

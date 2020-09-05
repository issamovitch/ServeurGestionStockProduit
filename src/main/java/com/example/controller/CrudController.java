package com.example.controller;

import com.example.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrudController<T,X>  {

    @Autowired
    private ICrudService<T, X> service;

    @GetMapping
    public List<T> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void add(@RequestBody T entity) {
        service.add(entity);
    }

    @PutMapping
    public void updateT(@RequestBody T entity) {
        service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteT(@PathVariable("id") X id) {
        service.delete(id);
    }
}

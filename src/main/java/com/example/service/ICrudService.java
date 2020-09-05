package com.example.service;

import com.example.entity.Produit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICrudService<T, X> {

    List<T> getAll();

    void add(T entry);

    void update(T entity);

    void delete(X id);
}

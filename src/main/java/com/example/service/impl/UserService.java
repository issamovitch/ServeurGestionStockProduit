package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements ICrudService<User, Long> {

    @Autowired
    private UserRepository produitRepository;

    @Override
    public List<User> getAll() {
        return produitRepository.findAll();
    }

    @Override
    public void add(User produit) {
        produitRepository.save(produit);
    }

    @Override
    public void update(User produit) {
        produitRepository.save(produit);
    }

    @Override
    public void delete(Long id) {
        //User produit = new User();
        //produit.setId(id);
        produitRepository.deleteById(id);
    }
}

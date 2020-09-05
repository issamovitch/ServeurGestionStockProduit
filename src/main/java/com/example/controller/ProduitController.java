package com.example.controller;

import com.example.service.ICrudService;
import com.example.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
public class ProduitController extends CrudController<Produit, Long>{
}

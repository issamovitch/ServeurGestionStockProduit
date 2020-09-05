package com.example.controller;

import com.example.entity.User;
import com.example.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users_crud")
public class CrudUserController extends CrudController<User, Long> {
    

}

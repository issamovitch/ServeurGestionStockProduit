package com.example;

import com.example.entity.Produit;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.ProduitRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.utils.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args){
        ApplicationContext ctx = new SpringApplication(DemoApplication.class).run(args);

        // Produits
        ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
        if(produitRepository.count() <= 0){
            List<Produit> produits = new ArrayList<Produit>();
            produits.add(new Produit("Livre", 50, 20));
            produits.add(new Produit("Cahier", 200, 5.25));
            produits.add(new Produit("Stylo", 500, 2.10));
            produitRepository.saveAll(produits);
        }

        //Roles
        RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
        Role role1, role2;
        if(roleRepository.count()<= 0){
            role1 = new Role(RoleEnum.ROLE_USER);
            role2 = new Role(RoleEnum.ROLE_ADMIN);
            roleRepository.saveAll(Arrays.asList(role1, role2));
        }else{
            role1 = roleRepository.findRoleByName(RoleEnum.ROLE_USER.getName());
            role2 = roleRepository.findRoleByName(RoleEnum.ROLE_ADMIN.getName());
        }

        // Users
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        if(userRepository.count() <= 0){
            User user1 = new User("user", "password", true);
            user1.setRoles(Arrays.asList(role1));
            User user2 = new User("admin", "password", true);
            user2.setRoles(Arrays.asList(role1, role2));
            userRepository.saveAll(Arrays.asList(user1, user2));
        }


    }

}

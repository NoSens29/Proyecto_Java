package com.informatorio.proyectoinformatorio.controller;

import com.informatorio.proyectoinformatorio.entity.User;
import com.informatorio.proyectoinformatorio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create a new user
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    //Read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {

        Optional<User> oUser = userService.findById(userId);

        if(!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
    }

    //Update and user
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable(value = "id") Long userId){
        Optional<User> user = userService.findById(userId);

        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        user.get().setName(userDetails.getName());
        user.get().setLastname(userDetails.getLastname());
        user.get().setEmail(userDetails.getEmail());
        user.get().setCity(userDetails.getCity());
        user.get().setCountry(userDetails.getCountry());
        user.get().setProvince(userDetails.getProvince());
        user.get().setPassword(userDetails.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));

    }

    //Detele an User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {
        if (!userService.findById(userId).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }


    //Read all Users
    @GetMapping
    public List<User> readAll(
            @RequestParam(required = false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate date,
            @RequestParam(required = false) Integer size) {

            List<User> users= StreamSupport
                    .stream(userService.finAll().spliterator(), false)
                    .collect(Collectors.toList());
            return  users;
    }


    //Read users by city
    @GetMapping("/search")
    public ResponseEntity<?> findByCity(@RequestParam String ciudad){
        List<User> user = userService.findByCity(ciudad);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

package com.informatorio.proyectoinformatorio.service;

import com.informatorio.proyectoinformatorio.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Iterable<User> finAll();

    public Page<User> finAll(Pageable pageable);

    public Optional<User> findById(Long id);

    public List<User> findByCity(String city);

    public User save(User user);

    public void deleteById(Long id);

}

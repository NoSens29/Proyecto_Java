package com.informatorio.proyectoinformatorio.service;

import com.informatorio.proyectoinformatorio.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostService {

    public Iterable<Post> finAll();

    public Page<Post> finAll(Pageable pageable);

    public Optional<Post> findById(Long id);

    public  Post save(Post post);

    public void deleteById(Long id);

}

package com.informatorio.proyectoinformatorio.service;

import com.informatorio.proyectoinformatorio.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CommentService {

    public Iterable<Comment> finAll();

    public Page<Comment> finAll(Pageable pageable);

    public Optional<Comment> findById(Long id);

    public  Comment save(Comment post);

    public void deleteById(Long id);

}

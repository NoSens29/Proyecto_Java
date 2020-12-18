package com.informatorio.proyectoinformatorio.service;

import com.informatorio.proyectoinformatorio.entity.Comment;
import com.informatorio.proyectoinformatorio.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRespository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Comment> finAll() {
        return commentRespository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Comment> finAll(Pageable pageable) {
        return commentRespository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comment> findById(Long id) {
        return commentRespository.findById(id);
    }

    @Override
    @Transactional
    public Comment save(Comment comment) {
        return commentRespository.save(comment);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        commentRespository.deleteById(id);

    }
}

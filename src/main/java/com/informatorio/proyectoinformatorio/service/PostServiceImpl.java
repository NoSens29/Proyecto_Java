package com.informatorio.proyectoinformatorio.service;

import com.informatorio.proyectoinformatorio.entity.Post;
import com.informatorio.proyectoinformatorio.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRespository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Post> finAll() {
        return postRespository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Post> finAll(Pageable pageable) {
        return postRespository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Post> findById(Long id) {
        return postRespository.findById(id);
    }

    @Override
    @Transactional
    public Post save(Post post) {
        return postRespository.save(post);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        postRespository.deleteById(id);

    }
    /*
    @Override
    @Transactional(readOnly = true)
    public List<Post> findStringOnTitle(String title) {
        return postRespository.findStringOnTitle(title);
    }
    */

}

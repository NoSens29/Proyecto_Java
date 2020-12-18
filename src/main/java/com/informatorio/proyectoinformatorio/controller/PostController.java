package com.informatorio.proyectoinformatorio.controller;

import com.informatorio.proyectoinformatorio.entity.Post;
import com.informatorio.proyectoinformatorio.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    //Create a new post
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Post post) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post));
    }

    //Read an user
    @GetMapping("/{id")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long postId){
        Optional<Post> oPost = postService.findById(postId);

        if(!oPost.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oPost);
    }


    //Update and post
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Post postDetails, @PathVariable(value = "id") Long postId){
        Optional<Post> post = postService.findById(postId);

        if( !post.isPresent()){
            return ResponseEntity.notFound().build();
        }

        post.get().setTitle(postDetails.getTitle());
        post.get().setDescription(postDetails.getDescription());
        post.get().setContent(postDetails.getContent());
        post.get().setPublished(postDetails.getPublished());

        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post.get()));

    }

    //Detele an post
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long postId) {
        if (!postService.findById(postId).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        postService.deleteById (postId);
        return ResponseEntity.ok().build();
    }

    //Read all posts
    @GetMapping
    public List <Post> readAll() {

        List<Post> posts= StreamSupport
                .stream(postService.finAll().spliterator(), false)
                .collect(Collectors.toList());
        return  posts;
    }

}

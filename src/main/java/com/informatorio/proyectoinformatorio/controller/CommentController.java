package com.informatorio.proyectoinformatorio.controller;

import com.informatorio.proyectoinformatorio.entity.Comment;
import com.informatorio.proyectoinformatorio.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //Create a new comment
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Comment comment) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(comment));
    }

    //Read an user
    @GetMapping("/{id")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long commentId){
        Optional<Comment> oComment = commentService.findById(commentId);

        if(!oComment.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oComment);
    }


    //Update and comment
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Comment commentDetails, @PathVariable(value = "id") Long commentId){
        Optional<Comment> comment = commentService.findById(commentId);

        if( !comment.isPresent()){
            return ResponseEntity.notFound().build();
        }


        comment.get().setComment(commentDetails.getComment());

        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(comment.get()));

    }

    //Detele an comment
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long commentId) {
        if (!commentService.findById(commentId).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        commentService.deleteById (commentId);
        return ResponseEntity.ok().build();
    }

    //Read all comments
    @GetMapping
    public List <Comment> readAll() {
        List<Comment> comments= StreamSupport
                .stream(commentService.finAll().spliterator(), false)
                .collect(Collectors.toList());
        return  comments;
    }

}

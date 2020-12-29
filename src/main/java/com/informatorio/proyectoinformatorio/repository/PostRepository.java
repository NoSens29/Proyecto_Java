package com.informatorio.proyectoinformatorio.repository;

import com.informatorio.proyectoinformatorio.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
   //
}

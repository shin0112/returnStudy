package com.example.returnstudy.Repository;

import com.example.returnstudy.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

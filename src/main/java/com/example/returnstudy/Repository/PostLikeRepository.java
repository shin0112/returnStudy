package com.example.returnstudy.Repository;

import com.example.returnstudy.Entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    List<PostLike> findAllByMemberId(Long id);
    List<PostLike> findAllByPostId(Long id);
}

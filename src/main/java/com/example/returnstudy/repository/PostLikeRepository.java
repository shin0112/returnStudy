package com.example.returnstudy.repository;

import com.example.returnstudy.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    List<PostLike> findAllByMemberId(Long id);
    List<PostLike> findAllByPostId(Long id);

    Optional<PostLike> findByMemberIdAndPostId(Long memberId, Long postId);
}

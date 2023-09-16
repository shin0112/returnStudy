package com.example.returnstudy.Service;

import com.example.returnstudy.Entity.Member;
import com.example.returnstudy.Entity.Post;
import com.example.returnstudy.Entity.PostLike;
import com.example.returnstudy.Repository.MemberRepository;
import com.example.returnstudy.Repository.PostLikeRepository;
import com.example.returnstudy.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public void SaveMemberAndPost() {

        // 회원1 저장
        Member member1 = new Member();
        member1.setStudentId(2021105614);
        member1.setName("신주은");
        member1.setGeneration("1st");
        member1.setClub("RETURN");
        memberRepository.save(member1);

        // 회원2 저장
        Member member2 = new Member();
        member2.setStudentId(2022110020);
        member2.setName("홍길동");
        member2.setGeneration("2nd");
        member2.setClub("RETURN");
        memberRepository.save(member2);

        // 회원3 저장
        Member member3 = new Member();
        member3.setStudentId(2023115020);
        member3.setName("아무개");
        member3.setGeneration("3rd");
        member3.setClub("RETURN");
        memberRepository.save(member3);

        // 게시글1 저장
        Post post1 = new Post();
        post1.setTitle("이번에 태풍온대");
        post1.setContent("이번에 카눈이라는 엄청난 태풍이 온대");
        post1.setMember(member1);
        postRepository.save(post1);

        // 게시글2 저장
        Post post2 = new Post();
        post2.setTitle("날씨");
        post2.setContent("요즘에 날씨 많이 풀린 것 같아");
        post2.setMember(member2);
        postRepository.save(post2);

        // 멤버2가 게시글1에 좋아요를 누름
        PostLike postLike1 = new PostLike();
        postLike1.setPost(post1);
        postLike1.setMember(member2);
        postLikeRepository.save(postLike1);

        // 멤버3이 게시글1에 좋아요를 누름
        PostLike postLike2 = new PostLike();
        postLike2.setPost(post1);
        postLike2.setMember(member3);
        postLikeRepository.save(postLike2);

        // 멤버1이 게시글2에 좋아요를 누름
        PostLike postLike3 = new PostLike();
        postLike3.setPost(post2);
        postLike3.setMember(member1);
        postLikeRepository.save(postLike3);

        // 회원이 좋아요를 누른 게시글 목록
        log.info("Member1's list of like posts : " + postLikeRepository.findAllByMemberId(member1.getId()).stream().map(postLike -> postLike.getPost()).collect(Collectors.toList()).toString());
        log.info("Member2's list of like posts : " + postLikeRepository.findAllByMemberId(member2.getId()).stream().map(postLike -> postLike.getPost()).collect(Collectors.toList()).toString());
        log.info("Member3's list of like posts : " + postLikeRepository.findAllByMemberId(member3.getId()).stream().map(postLike -> postLike.getPost()).collect(Collectors.toList()).toString());

        // 게시글에 좋아요를 누른 회원 목록
        log.info("List of members of post1 : " + postLikeRepository.findAllByPostId(post1.getId()).stream().map(postLike -> postLike.getMember()).collect(Collectors.toList()).toString());
        log.info("List of members of post2 : " + postLikeRepository.findAllByPostId(post2.getId()).stream().map(postLike -> postLike.getMember()).collect(Collectors.toList()).toString());

    }
}

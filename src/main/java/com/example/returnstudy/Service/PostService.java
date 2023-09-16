package com.example.returnstudy.Service;

import com.example.returnstudy.Entity.Member;
import com.example.returnstudy.Entity.Post;
import com.example.returnstudy.Repository.MemberRepository;
import com.example.returnstudy.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public void SaveAndReadPostWriter() {

        Member member = new Member();
        member.setStudentId(2021105614);
        member.setName("신주은");
        member.setGeneration("1st");
        member.setClub("RETURN");
        memberRepository.save(member);
        log.info("저장한 회원 ID : " + member.getId());

        Post post1 = new Post();
        post1.setTitle("이번에 태풍온대");
        post1.setContent("이번에 카눈이라는 엄청난 태풍이 온대");
        post1.setMember(member);
        postRepository.save(post1);
        log.info("지정한 게시글 ID : " + post1.getId());

        Post post2 = new Post();
        post2.setTitle("날씨");
        post2.setContent("요즘에 날씨 많이 풀린 것 같아");
        post2.setMember(member);
        postRepository.save(post2);
        log.info("저장한 게시글 ID : " + post2.getId());

        log.info("saved post1 info : " + postRepository.findById(post1.getId()).get());
        log.info("saved post2 info : " + postRepository.findById(post2.getId()).get());
        log.info("writer info : " + postRepository.findById(post1.getId()).get().getMember().toString());
        log.info("writer info : " + postRepository.findById(post2.getId()).get().getMember().toString());

    }

    public void SaveAndReadMemberWithPost() {

        Member member = new Member();
        member.setStudentId(2021105614);
        member.setName("신주은");
        member.setGeneration("1st");
        member.setClub("RETURN");
        memberRepository.save(member);

        Post post1 = new Post();
        post1.setTitle("이번에 태풍온대");
        post1.setContent("이번에 카눈이라는 엄청난 태풍이 온대");
        post1.setMember(member);
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setTitle("날씨");
        post2.setContent("요즘에 날씨 많이 풀린 것 같아");
        post2.setMember(member);
        postRepository.save(post2);

        log.info(memberRepository.findById(member.getId()).get().getPosts().toString());

    }

}

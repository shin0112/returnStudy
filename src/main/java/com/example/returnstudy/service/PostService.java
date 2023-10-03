package com.example.returnstudy.service;

import com.example.returnstudy.dto.PostRequestDto;
import com.example.returnstudy.dto.PostResponseDto;
import com.example.returnstudy.entity.Category;
import com.example.returnstudy.entity.Member;
import com.example.returnstudy.entity.Post;
import com.example.returnstudy.repository.CategoryRepository;
import com.example.returnstudy.repository.MemberRepository;
import com.example.returnstudy.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public ResponseEntity<?> savePost(PostRequestDto postRequestDto) {
        Optional<Member> writer = memberRepository.findByStudentId(postRequestDto.getStudentId());
        if (writer.isPresent()) {
            Post post = new Post();
            post.setMember(writer.get());

            post.setTitle(postRequestDto.getTitle());
            post.setContent(postRequestDto.getContent());

            postRepository.save(post);

            Optional<Category> category = categoryRepository.findByCategory(postRequestDto.getCategory());
            if (category.isPresent()) {
                category.get().getPosts().add(post);
                categoryRepository.save(category.get());
            } else {
                Category newCategory = new Category();
                newCategory.setCategory(postRequestDto.getCategory());
                newCategory.getPosts().add(post);
                categoryRepository.save(newCategory);
            }

            Map<String, Long> response = new HashMap<>();
            response.put("등록된 게시글 번호", post.getId());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<?> readPost(Long id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isPresent()) {
            PostResponseDto postResponseDto = new PostResponseDto();
            postResponseDto.setId(post.get().getId());
            postResponseDto.setTitle(post.get().getTitle());
            postResponseDto.setContent(post.get().getContent());
            postResponseDto.setStudentId(post.get().getMember().getStudentId());
            return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public ResponseEntity<?> updatePost(Long id, PostRequestDto postRequestDto) {
        Optional<Post> post = postRepository.findById(id);
        Optional<Member> member = memberRepository.findByStudentId(postRequestDto.getStudentId());
        if (post.isPresent() && member.isPresent()) {
            post.get().setMember(member.get());
            post.get().setTitle(postRequestDto.getTitle());
            post.get().setContent(postRequestDto.getContent());

            postRepository.save(post.get());

            Optional<Category> category = categoryRepository.findByCategory(postRequestDto.getCategory());
            if (category.isPresent()) {
                category.get().getPosts().add(post.get());
                categoryRepository.save(category.get());
            } else {
                Category newCategory = new Category();
                newCategory.setCategory(postRequestDto.getCategory());
                newCategory.getPosts().add(post.get());
                categoryRepository.save(newCategory);
            }

            Map<String, Long> response = new HashMap<>();
            response.put("수정된 게시글 번호", post.get().getId());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }

    @Transactional
    public ResponseEntity<Void> deletePost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            log.info("삭제");
            postRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public void SaveAndReadPostWriter() {

        Member member = new Member();
        member.setStudentId("2021105614");
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
        member.setStudentId("2021105614");
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

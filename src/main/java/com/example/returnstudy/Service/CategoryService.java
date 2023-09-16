package com.example.returnstudy.Service;

import com.example.returnstudy.Entity.Category;
import com.example.returnstudy.Entity.Member;
import com.example.returnstudy.Entity.Post;
import com.example.returnstudy.Repository.CategoryRepository;
import com.example.returnstudy.Repository.MemberRepository;
import com.example.returnstudy.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public void OneToManyPostHashTagSave() {

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

        Category category = new Category();
        category.setCategory("기상속보");
        category.getPosts().addAll(List.of(post1, post2)); // 리스트에 post 저장
        categoryRepository.save(category);

        log.info("Posts of Category : " + categoryRepository.findById(category.getId()).get().getPosts().toString());

    }

}

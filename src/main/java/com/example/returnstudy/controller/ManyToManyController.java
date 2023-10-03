package com.example.returnstudy.controller;

import com.example.returnstudy.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManyToManyController {

    private final PostLikeService postLikeService;

    // http://localhost:8080/many-to-many
    @GetMapping("many-to-many")
    public void Save() {
        postLikeService.SaveMemberAndPost();
    }

}

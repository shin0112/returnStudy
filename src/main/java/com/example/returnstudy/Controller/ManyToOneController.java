package com.example.returnstudy.Controller;

import com.example.returnstudy.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManyToOneController {

    private final PostService postService;

    // http://localhost:8080/many-to-one
    @GetMapping("/many-to-one")
    public void ManyToOneTest() {
        postService.SaveAndReadPostWriter();
    }

    // http://localhost:8080/many-to-one-bidirect
    @GetMapping("/many-to-one-bidirect")
    public void ManyToOneBidirectTest() {
        postService.SaveAndReadMemberWithPost();
    }
}

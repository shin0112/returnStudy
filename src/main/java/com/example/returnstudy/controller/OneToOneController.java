package com.example.returnstudy.controller;

import com.example.returnstudy.service.MemberDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OneToOneController {

    private final MemberDetailsService memberDetailsService;

    // http://localhost:8080/one-to-one
    @GetMapping("/one-to-one")
    public void OneToOneTest() {
        memberDetailsService.OneToOne();
    }

    // http://localhost:8080/one-to-one-bidirect
    @GetMapping("/one-to-one-bidirect")
    public void OneToOneBidirectTest() {
        memberDetailsService.OneToOneBidirect();
    }

}

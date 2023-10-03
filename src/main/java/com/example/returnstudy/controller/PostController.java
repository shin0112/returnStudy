package com.example.returnstudy.controller;

import com.example.returnstudy.dto.MemberRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/return")
public class PostController {

    // http://localhost:8080/return/member/registration
    @PostMapping("/member/registration")
    /*
    public MemberRequestDto registerMember(@RequestBody MemberRequestDto memberRequestDto) {
        System.out.println(memberRequestDto.toString());
        return memberRequestDto;
    }
    */ public ResponseEntity<MemberRequestDto> registerMember(@RequestBody MemberRequestDto memberRequestDto) {
        System.out.println(memberRequestDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(memberRequestDto);
    }

}

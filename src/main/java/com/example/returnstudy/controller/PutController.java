package com.example.returnstudy.controller;

import com.example.returnstudy.dto.MemberRequestDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/return")
public class PutController {

    // http://localhost:8080/return/member/update
    @PutMapping("/member/update")
    public MemberRequestDto registerMember(@RequestBody MemberRequestDto memberRequestDto) {
        System.out.println(memberRequestDto.toString());
        return memberRequestDto;
    }

}

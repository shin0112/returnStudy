package com.example.returnstudy.Controller;

import com.example.returnstudy.DTO.MemberDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/return")
public class PutController {

    // http://localhost:8080/return/member/update
    @PutMapping("/member/update")
    public MemberDto registerMember(@RequestBody MemberDto memberDto) {
        System.out.println(memberDto.toString());
        return memberDto;
    }

}

package com.example.returnstudy.Controller;

import com.example.returnstudy.DTO.MemberDto;
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
    public MemberDto registerMember(@RequestBody MemberDto memberDto) {
        System.out.println(memberDto.toString());
        return memberDto;
    }
    */
    public ResponseEntity<MemberDto> registerMember(@RequestBody MemberDto memberDto) {
        System.out.println(memberDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(memberDto);
    }

}

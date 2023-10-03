package com.example.returnstudy.controller;

import com.example.returnstudy.dto.MemberRequestDto;
import com.example.returnstudy.dto.MemberResponseDto;
import com.example.returnstudy.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class MemberController {

    private final MemberService memberService;

    @Autowired // 핵심 로직을 처리하는 서비스 클래스를 의존성 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping (value = "/member/{id}")
    public ResponseEntity<MemberResponseDto> getStudentInfo(@PathVariable(value = "id") Long id ) {
        System.out.println("회원 번호 : " + id);
        MemberResponseDto memberResponseDto = memberService.getMember(id);
        if(memberResponseDto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(memberResponseDto);
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<MemberResponseDto> registerMember(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        System.out.println(memberRequestDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMember((memberRequestDto)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MemberResponseDto> registerMember(@PathVariable(value = "id") Long id, @RequestBody MemberRequestDto memberRequestDto) {
        System.out.println(memberRequestDto.toString());
        MemberResponseDto memberResponseDto = memberService.updateMember(id, memberRequestDto);

        if (memberResponseDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberResponseDto);
        }
    }

    @DeleteMapping("/withdraw/{id}")
    public ResponseEntity<Void> dropOutMember(@PathVariable(value = "id") Long id) {
        if (memberService.isDeleteMember(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/orphan/{id}")
    public ResponseEntity<Void> orphanMemberDetails(@PathVariable(value = "id") Long id) {
        memberService.MakeOrphanMemberDetails(id);
        return ResponseEntity.ok().build();
    }

}

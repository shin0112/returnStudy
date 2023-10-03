package com.example.returnstudy.controller;

import com.example.returnstudy.dto.MemberRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/return")
public class GetController {

    // http://localhost:8080/return/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloworld() {
        return "hello";
    }

    // http://localhost:8080/return/study-name
    @RequestMapping(value = "/study-name", method = RequestMethod.GET)
    public String getStudyName() {
        return "SpringBoot";
    }

    // http://localhost:8080/return/member/2021105614
//    @GetMapping(value = "/member/{studentId}")
//    public Integer getStudentId(@PathVariable(value = "studentId", required = false) Integer studentId) {
//        System.out.println(studentId);
//        return studentId;
//    }

    // http://localhost:8080/return/member/2021105614/name/신주은
    @GetMapping(value = "/member/{studentId}/name/{name}")
    public HashMap<String, Integer> getStudentIdAndName(@PathVariable(value = "studentId")
                                                        Integer studentId,
                                                        @PathVariable(value = "name")
                                                        String name) {
        System.out.println(studentId);
        System.out.println(name);
        HashMap<String, Integer> response = new HashMap<>();
        response.put(name, studentId);
        return response;
    }

    // http://localhost:8080/return/member?id=2021105614&name=신주은
    @GetMapping(value = "/member")
    public HashMap<String, Integer> getStudentInfo(@RequestParam(value = "id")
                                                   Integer studentId,
                                                   @RequestParam(value = "name")
                                                   String name) {
        System.out.println(studentId);
        System.out.println(name);
        HashMap<String, Integer> response = new HashMap<>();
        response.put(name, studentId);
        return response;
    }

    // http://localhost:8080/return/member-info?studentId=2021105614&name=신주은&year=21&club=return
    @GetMapping(value = "/member-info")
    public MemberRequestDto getStudentFromDTO(MemberRequestDto memberRequestDto) {
        return memberRequestDto;
    }

}

package com.example.returnstudy.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class DeleteController {

    // http://localhost:8080/return/member/withdraw/21?studentId=2021105614
    @DeleteMapping("member/withdraw/{year}")
    public String dropOutMember(@PathVariable(value = "year")
                                Integer year,
                                @RequestParam(value = "studentId")
                                Long studentId) {
        return "삭제되었습니다.";
    }

}

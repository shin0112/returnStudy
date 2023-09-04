package com.example.returnstudy.DTO;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/return")
public class MemberDto {

    Integer studentId;
    String name;
    Integer year;
    String club;

    public MemberDto() {
    }

    public MemberDto(Integer studentId, String name, Integer year, String club) {
        this.studentId = studentId;
        this.name = name;
        this.year = year;
        this.club = club;
    }

    public MemberDto(Integer studentId) {
        this.studentId = studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "studentId='" + studentId +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", club='" + club + '\'' +
                '}';
    }

}


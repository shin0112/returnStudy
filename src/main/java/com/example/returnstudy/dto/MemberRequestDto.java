package com.example.returnstudy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberRequestDto {

    @NotBlank
    private String studentId;
    @NotBlank
    @Size(min = 2, max = 4)
    private String name;
    @NotBlank
    private String generation;
    @NotBlank
    private String club;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@khu\\.ac\\.kr$")
    private String email;
    @Pattern(regexp = "^010\\d{8}$")
    private String phoneNumber;
    @Size(min = 0, max = 30)
    private String statusMsg;

}

//@RestController
//@RequestMapping("/return")
//public class MemberRequestDto {
//
//    Integer studentId;
//    String name;
//    Integer year;
//    String club;
//
//    public MemberRequestDto() {
//    }
//
//    public MemberRequestDto(Integer studentId, String name, Integer year, String club) {
//        this.studentId = studentId;
//        this.name = name;
//        this.year = year;
//        this.club = club;
//    }
//
//    public MemberRequestDto(Integer studentId) {
//        this.studentId = studentId;
//    }
//
//    public void setStudentId(Integer studentId) {
//        this.studentId = studentId;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setYear(Integer year) {
//        this.year = year;
//    }
//
//    public void setClub(String club) {
//        this.club = club;
//    }
//
//    @Override
//    public String toString() {
//        return "MemberRequestDto{" +
//                "studentId='" + studentId +
//                ", name='" + name + '\'' +
//                ", year=" + year +
//                ", club='" + club + '\'' +
//                '}';
//    }
//
//}

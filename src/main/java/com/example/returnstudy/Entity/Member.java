package com.example.returnstudy.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //PK

    @Column(nullable = false)
    private Integer studentId; //학번
    @Column(nullable = false)
    private String name; //이름
    @Column(nullable = false)
    private String generation; //동아리 기수
    @Column(nullable = false)
    private String club; //동아리

}

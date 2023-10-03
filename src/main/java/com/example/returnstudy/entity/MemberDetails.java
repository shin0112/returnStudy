package com.example.returnstudy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "memberDetails")
public class MemberDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = false, nullable = false)
    private String email;

    @Column(unique = false, nullable = false)
    private String phoneNumber;

    @Column(nullable = true, length = 255)
    private String statusMsg;

    @Column
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    @OneToOne(mappedBy = "memberDetails")
    @ToString.Exclude // 순환 참조 방지
    private Member member;

}

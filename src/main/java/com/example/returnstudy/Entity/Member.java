package com.example.returnstudy.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
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

    @OneToOne
    @JoinColumn(name = "member_details_id")
    private MemberDetails memberDetails;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER) // 즉시 로딩으로 가져옴
    @ToString.Exclude
    private List<Post> posts = new ArrayList<>();

    // 지연로딩 전략으로 Member 엔티티를 반환할 때, 실제 객체가 아닌 프록시(proxy) 객체로 PostLike 엔티티를 가져옴
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PostLike> postLikes = new ArrayList<>();

}

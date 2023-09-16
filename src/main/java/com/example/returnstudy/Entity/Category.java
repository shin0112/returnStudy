package com.example.returnstudy.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String category;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id") // post 엔티티에서 외래키 관리
    @ToString.Exclude
    private List<Post> posts = new ArrayList<>();

}

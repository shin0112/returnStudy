package com.example.returnstudy.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String studentId;
}

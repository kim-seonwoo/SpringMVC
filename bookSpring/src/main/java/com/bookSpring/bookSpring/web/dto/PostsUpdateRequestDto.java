package com.bookSpring.bookSpring.web.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto
{
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

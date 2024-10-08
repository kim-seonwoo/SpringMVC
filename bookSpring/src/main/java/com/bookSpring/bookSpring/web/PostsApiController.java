package com.bookSpring.bookSpring.web;

import com.bookSpring.bookSpring.domain.*;
import com.bookSpring.bookSpring.service.posts.*;
import com.bookSpring.bookSpring.web.dto.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable(name = "id") Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable(name = "id") Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable(name = "id") Long id) {
        postsService.delete(id);
        return id;
    }
}

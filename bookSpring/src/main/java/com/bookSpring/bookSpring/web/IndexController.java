package com.bookSpring.bookSpring.web;

import ch.qos.logback.core.model.*;
import com.bookSpring.bookSpring.config.auth.*;
import com.bookSpring.bookSpring.config.auth.dto.*;
import com.bookSpring.bookSpring.service.posts.*;
import com.bookSpring.bookSpring.web.dto.*;
import jakarta.servlet.http.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String save() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable(name = "id") Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

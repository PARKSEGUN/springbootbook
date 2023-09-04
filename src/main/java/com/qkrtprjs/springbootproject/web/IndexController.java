package com.qkrtprjs.springbootproject.web;

import com.qkrtprjs.springbootproject.config.auth.LoginUser;
import com.qkrtprjs.springbootproject.config.auth.dto.SessionUser;
import com.qkrtprjs.springbootproject.service.posts.PostsService;
import com.qkrtprjs.springbootproject.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto postsResponseDto = postsService.findById(id);
        model.addAttribute("post", postsResponseDto);
        return "posts-update";
    }
}

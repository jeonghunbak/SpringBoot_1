package com.cloud.boot.web;

import com.cloud.boot.config.auth.LoginUser;
import com.cloud.boot.config.auth.dto.SessionUser;
import com.cloud.boot.service.posts.PostsService;
import com.cloud.boot.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class indexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null){
            model.addAttribute("name", user.getName()); // userName window에서 사용하는 환경변수 라 PC 유저명 출력됨
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String save(){
        return "save";
    }

    @GetMapping("/posts/update/{id}")
    public String update(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "update";
    }

}

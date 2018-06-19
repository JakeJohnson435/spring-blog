package com.codeup.blog;

import com.codeup.blog.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsIndex() {
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId() {
        return "/posts/show";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "Create a post";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String postsInsert() {
        return "insert a post";
    }
}

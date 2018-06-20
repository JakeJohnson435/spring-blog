package com.codeup.blog;

import com.codeup.blog.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable long id,  Model model) {
        model.addAttribute("post", postService.getPost(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String postsCreate(Model model) {
        model.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsInsert(@ModelAttribute Post newPost) {
        postService.savePost(newPost);
        return "redirect:/posts";
    }

}

package com.codeup.blog;

import com.codeup.blog.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@Controller
public class PostController {

    private final PostRepo postRepo;

    public PostController(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postRepo.findAll());

        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable long id,  Model model) {
        model.addAttribute("post", postRepo.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String postsCreate(Model model) {
        model.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsInsert(@ModelAttribute Post newPost) {
        postRepo.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@ModelAttribute Post post, @PathVariable long id, Model model){
        post.setId(id);
        model.addAttribute("post", postRepo.findOne(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String handleEdit(@ModelAttribute Post post){
        postRepo.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post){
        postRepo.delete(post);
        return "redirect:/posts";
    }

}

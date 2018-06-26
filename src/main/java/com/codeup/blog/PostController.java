package com.codeup.blog;

import com.codeup.blog.Models.Post;
import com.codeup.blog.Models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private final PostRepo postRepo;
    private final UserRepository userRepo;

    public PostController(PostRepo postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable long id,  Model model) {
        model.addAttribute("post", postRepo.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsCreate(Model model) {
        model.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsInsert(@ModelAttribute Post newPost) {
        String body = newPost.getBody();
        if (body.length() > 30) {
            String subtitle = body.substring(0, 30) + "...";
            newPost.setSubtitle(subtitle);
        } else {
            newPost.setSubtitle(body);
        }
        newPost.setOwner((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        postRepo.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@ModelAttribute Post post, @PathVariable long id, Model model){
        post.setId(id);
        model.addAttribute("post", postRepo.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String handleEdit(@ModelAttribute Post post){
        String body = post.getBody();
        if (body.length() > 30) {
            String subtitle = body.substring(0, 30) + "...";
            post.setSubtitle(subtitle);
        } else {
            post.setSubtitle(body);
        }
        postRepo.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post){
        postRepo.delete(post);
        return "redirect:/posts";
    }

}

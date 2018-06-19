package com.codeup.blog;

import com.codeup.blog.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        List<Post> posts = arrayOfPosts();
        model.addAttribute("posts", posts);

        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable long id,  Model model) {
        Post post = new Post("here is my title", "Here is the body");
        model.addAttribute("post", post);
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

    private List<Post> arrayOfPosts(){
        return Arrays.asList(
        new Post("Title 1", "Body 1"),
        new Post("Title 2", "Body 2")
        );
    }
}

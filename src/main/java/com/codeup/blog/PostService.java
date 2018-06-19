package com.codeup.blog;

import com.codeup.blog.Models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPost(long id) {
        return posts.get(((int) id) - 1);
    }

    public void createPosts() {
        posts.add(new Post("Title numero uno", "Description to the first post"));
        posts.add(new Post("2nd post, I'm on a roll", "Speaking of roll, did you see my game? Check it out on the navbar"));
        posts.add(new Post("I'm running out of ideas", "I need to buy some dress shoes"));
        posts.add(new Post("Anotha One", "Keep it goin"));
    }

}

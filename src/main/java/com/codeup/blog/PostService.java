package com.codeup.blog;

import com.codeup.blog.Models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService{

    private List<Post> posts;
    private PostRepo postRepo;


    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPost(long id) {
        return posts.get(((int) id) - 1);
    }

    public void savePost(Post post){
        post.setId(this.posts.size()+1);
        this.posts.add(post);
    }

}

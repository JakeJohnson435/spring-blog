package com.codeup.blog;

import com.codeup.blog.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {

}

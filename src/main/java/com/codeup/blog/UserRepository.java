package com.codeup.blog;

import com.codeup.blog.Models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
//    public User findByUsername(String username);
}

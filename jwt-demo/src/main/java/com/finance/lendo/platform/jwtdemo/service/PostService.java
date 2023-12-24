package com.finance.lendo.platform.jwtdemo.service;

import com.finance.lendo.platform.jwtdemo.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    List<Post> getPostsByUserId(Integer userId);
}

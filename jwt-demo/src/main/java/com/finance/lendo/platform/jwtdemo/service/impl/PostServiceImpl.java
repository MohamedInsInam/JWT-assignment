package com.finance.lendo.platform.jwtdemo.service.impl;

import com.finance.lendo.platform.jwtdemo.clientUtil.WebClientUtil;
import com.finance.lendo.platform.jwtdemo.model.Post;
import com.finance.lendo.platform.jwtdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Value("${lendo.post.url}")
    private String postsUrl;

    @Autowired
    private WebClientUtil webClientUtil;

    @Override
    public List<Post> getAllPosts() {
        Flux<Post> postModelFlux = webClientUtil.getAll(postsUrl, Post.class);
        return postModelFlux.collectList().block();
    }

    @Override
    public List<Post> getPostsByUserId(Integer userId) {
        Flux<Post> postModelFlux = webClientUtil.getAll(postsUrl, Post.class);
        List<Post> allPostsByUserId = postModelFlux.collectList().block();
        return allPostsByUserId.stream().filter(post -> userId.equals(post.getUser_id())).collect(Collectors.toList());
    }

}
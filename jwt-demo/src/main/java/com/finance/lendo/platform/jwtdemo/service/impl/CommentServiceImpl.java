package com.finance.lendo.platform.jwtdemo.service.impl;

import com.finance.lendo.platform.jwtdemo.clientUtil.WebClientUtil;
import com.finance.lendo.platform.jwtdemo.model.Comment;
import com.finance.lendo.platform.jwtdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Value("${lendo.comment.url}")
    private String commentsUrl;

    @Autowired
    private WebClientUtil webClientUtil;

    @Override
    public List<Comment> getAllComments() {
        Flux<Comment> commentModelFlux = webClientUtil.getAll(commentsUrl, Comment.class);
        return commentModelFlux.collectList().block();
    }

    @Override
    public List<Comment> getCommentsByPostId(Integer postId) {
        Flux<Comment> commentModelFlux = webClientUtil.getAll(commentsUrl, Comment.class);
        return Objects.requireNonNull(commentModelFlux.collectList().block()).stream().filter(commentModel -> commentModel.getPost_id().equals(postId)).collect(Collectors.toList());
    }
}

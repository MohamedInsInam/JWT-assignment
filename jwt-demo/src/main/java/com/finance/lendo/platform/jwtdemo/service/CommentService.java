package com.finance.lendo.platform.jwtdemo.service;

import com.finance.lendo.platform.jwtdemo.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();

    List<Comment> getCommentsByPostId(Integer postId);
}

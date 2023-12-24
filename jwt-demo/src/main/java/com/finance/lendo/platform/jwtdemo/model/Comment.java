package com.finance.lendo.platform.jwtdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    private Long id;

    private Long post_id;

    private String name;

    private String email;

    private String body;

}
package com.cc.security.baseapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
@ToString
@Document
@RequiredArgsConstructor
@EqualsAndHashCode
public class SupportQuery {

    private String id;
    private final String username;
    private final String subject;
    private List<Post> posts = new ArrayList<>();
    private Calendar created = Calendar.getInstance();
    private boolean resolved;

    private void addPost(Post post){
        this.posts.add(post);
    }

    private void addPost(String post, String username){
        this.posts.add(new Post(username, post, System.currentTimeMillis()));
    }

    private void resolve(){
        this.resolved = true;
    }

    private void setResolve(boolean resolved){
        this.resolved = resolved;
    }
}

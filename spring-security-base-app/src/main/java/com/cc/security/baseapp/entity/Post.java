package com.cc.security.baseapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;

@Getter
@ToString
@EqualsAndHashCode
public class Post {

    private String id;
    private final String username;
    private final String content;
    private final long timestamp;

    public Post(String username, String content, long timestamp) {
        this.id = new ObjectId().toHexString();
        this.username = username;
        this.content = content;
        this.timestamp = timestamp;
    }
}

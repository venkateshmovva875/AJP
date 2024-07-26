package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class comments {
    private String content;
    @Id
    private int userId;
    private int postId;
    private String timestamp;

    // Constructor (optional)
    public comments(String content, int userId, int postId, String timestamp) {
        this.content = content;
        this.userId = userId;
        this.postId = postId;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

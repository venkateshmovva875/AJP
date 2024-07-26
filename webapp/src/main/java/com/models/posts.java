package com.models;
import javax.persistence.*;
@Entity
public class posts {
	@Id
    private int id;
    private String content;
    private int userId;
    private int postId;
    private String timestamp;

    // Constructor (optional)
    public posts() {
        // No-argument constructor required by Hibernate
    }
    public posts(int id, String content, int userId, int postId, String timestamp) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.postId = postId;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    @Override
    public String toString() {
        return "Post [id=" + id + ", content=" + content + ", postId=" + postId + ", timestamp=" + timestamp + ", userId=" + userId + "]";
    }
}


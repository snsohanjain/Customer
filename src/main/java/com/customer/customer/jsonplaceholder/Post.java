package com.customer.customer.jsonplaceholder;

public class Post {
    private final Integer userId;
    private final Integer id;
    private final String  title;
    private final Integer body;

    public Post(Integer userId, Integer id, String title, Integer body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body=" + body +
                '}';
    }
}

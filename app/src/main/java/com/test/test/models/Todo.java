package com.test.test.models;

import androidx.annotation.NonNull;

public class Todo {
    int userId, id;
    String title, completed;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }


    @NonNull
    @Override
    public String toString() {
        return "{\n" +
                "  \"userId\": " + userId + ",\n" +
                "  \"id\": " + id + ",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"completed\": " + completed + "\n" +
                "}";
    }
}

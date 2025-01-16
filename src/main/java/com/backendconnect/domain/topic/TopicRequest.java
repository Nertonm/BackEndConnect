package com.backendconnect.domain.topic;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class TopicRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String message;

    @NotBlank
    private LocalDateTime createdAt;

    @NotBlank
    private String status;

    @NotBlank
    private Long authorId;

    @NotBlank
    private Long courseId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}

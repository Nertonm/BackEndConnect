package com.backendconnect.domain.topic;

import java.time.LocalDateTime;

public record TopicInfo(long id, String title, String message, long courseId, long  userId, LocalDateTime createdAt) {
    public TopicInfo(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCourse(), topic.getAuthor(), topic.getCreatedAt());
    }
}

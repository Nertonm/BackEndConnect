package com.backendconnect.domain.topic;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topic {
    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @Column(name = "created_at") @NotNull
    private LocalDateTime createdAt;
    private boolean status;
    private long author;
    private long course;

    public Topic(TopicRequest topicRequest) {
        this.title = topicRequest.getTitle();
        this.message = topicRequest.getMessage();
        this.author = topicRequest.getAuthorId();
        this.course = topicRequest.getCourseId();
        this.createdAt = LocalDateTime.now();
        this.status = true;
    }
    public void update(TopicRequest topicRequest) {
        if (topicRequest.getTitle() != null) {
            this.title = topicRequest.getTitle();
        }
        if (topicRequest.getMessage() != null){
            this.message = topicRequest.getMessage();
        }
    }

    public void delete() {
        this.status = false;
    }
}

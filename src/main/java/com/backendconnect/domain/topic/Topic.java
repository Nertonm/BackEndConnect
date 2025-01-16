package com.backendconnect.domain.topic;

import com.backendconnect.domain.course.Course;
import com.backendconnect.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topic {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String message;
    @Column(name = "created_at")
    @NotNull
    private LocalDateTime createdAt;
    private String status;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Topic(TopicRequest topicRequest) {

        this.title = topicRequest.getTitle();
        this.message = topicRequest.getMessage();
        this.createdAt = LocalDateTime.now();
        this.status = "OPEN";
    }
    public long getId(){
        return id;
    }
}

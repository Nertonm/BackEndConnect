package com.backendconnect.domain.topic;

import com.backendconnect.domain.course.Course;
import com.backendconnect.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private String status;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "course", nullable = false)
    private Course course;

}

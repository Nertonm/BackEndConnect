package com.backendconnect.controller;

import com.backendconnect.domain.course.Course;
import com.backendconnect.domain.course.CourseRepository;
import com.backendconnect.domain.topic.Topic;
import com.backendconnect.domain.topic.TopicRepository;
import com.backendconnect.domain.topic.TopicRequest;
import com.backendconnect.domain.user.User;
import com.backendconnect.domain.user.UserRepository;
import jakarta.validation.Valid;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> createTopic(@RequestBody @Valid TopicRequest topicRequest, UriComponentsBuilder uriBuilder) {
        var topic = new Topic(topicRequest);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body();

    }
}

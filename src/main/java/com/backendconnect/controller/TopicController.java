package com.backendconnect.controller;

import com.backendconnect.domain.topic.Topic;
import com.backendconnect.domain.topic.TopicInfo;
import com.backendconnect.domain.topic.TopicRepository;
import com.backendconnect.domain.topic.TopicRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;


@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> createTopic(@RequestBody @Valid TopicRequest topicRequest, UriComponentsBuilder uriBuilder) {
        Optional<Topic> existingTopic = topicRepository.findByTitleAndMessage(topicRequest.getTitle(), topicRequest.getMessage());
        if (existingTopic.isPresent()) {
            return ResponseEntity.badRequest().body("A topic with the same title and message already exists.");
        }
        var topic = new Topic(topicRequest);
        topicRepository.save(topic);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicInfo(topic));
    }
}

package com.backendconnect.controller;

import com.backendconnect.domain.topic.Topic;
import com.backendconnect.domain.topic.TopicInfo;
import com.backendconnect.domain.topic.TopicRepository;
import com.backendconnect.domain.topic.TopicRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    @GetMapping
    public ResponseEntity<Object> listTopics(@RequestParam(required = false) Long courseId, @RequestParam(required = false) Integer year) {
        Pageable pageable = (Pageable) PageRequest.of(0,10);
        List<Topic> topics;
        if (courseId != null && year != null) {
            topics = topicRepository.findByCourseAndYear(courseId, year, pageable);
        } else {
            topics = topicRepository.findAllByOrderByIdDesc(pageable).getContent();
        }
        List<TopicInfo> topicInfos = topics.stream()
                .map(TopicInfo::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(topicInfos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTopic(@PathVariable long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new TopicInfo(topic.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTopic(@PathVariable long id, @RequestBody TopicRequest topicRequest) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        topic.get().update(topicRequest);
        topicRepository.save(topic.get());
        return ResponseEntity.ok(new TopicInfo(topic.get()));
    }
}

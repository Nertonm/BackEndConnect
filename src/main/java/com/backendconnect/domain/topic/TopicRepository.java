package com.backendconnect.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findByTitleAndMessage(String title, String message);
}

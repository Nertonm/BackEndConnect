package com.backendconnect.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query("SELECT t FROM Topic t WHERE t.course = :courseId AND YEAR(t.createdAt) = :year ORDER BY t.createdAt DESC")
    List<Topic> findByCourseAndYear(long courseId, int year, Pageable pageable);
    Optional<Topic> findByTitleAndMessage(String title, String message);
    Page<Topic> findAllByOrderByIdDesc(Pageable pageable);
}

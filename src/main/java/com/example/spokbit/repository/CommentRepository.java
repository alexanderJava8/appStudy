package com.example.spokbit.repository;

import com.example.spokbit.entitys.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.topic.id = :topicId")
    List<Comment> findCommentByTopicId(@Param("topicId") Long topicId);
}

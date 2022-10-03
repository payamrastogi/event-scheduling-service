package com.coddicted.question.repository;

import com.coddicted.question.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findAll();
    @Query("{tagSet._id: {$in: tagId}}")
    List<Question> findQuestionsByTag(String tagId);
}

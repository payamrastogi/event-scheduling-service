package com.coddicted.question.repository;

import com.coddicted.question.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagRepository extends MongoRepository<Tag, String> {
    List<Tag> findByValueStartsWith(String str);
}

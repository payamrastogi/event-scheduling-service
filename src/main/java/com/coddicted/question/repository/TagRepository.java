package com.coddicted.question.repository;

import com.coddicted.question.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagRepository extends MongoRepository<Tag, String> {
    Page<Tag> findByValueStartsWith(String str, Pageable pageable);
}

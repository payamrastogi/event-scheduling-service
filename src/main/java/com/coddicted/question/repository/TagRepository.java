package com.coddicted.question.repository;

import com.coddicted.question.model.Question;
import com.coddicted.question.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String>  {
}

package com.coddicted.question.service;

import com.coddicted.question.model.Tag;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    List<Tag> getTags(Pageable paging);
    Tag getTag(String id);
    List<Tag> getTagsStartsWith(String str, Pageable paging);
    Tag save(Tag tag);
}

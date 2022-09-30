package com.coddicted.question.service;

import com.coddicted.question.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTags();
    Tag getTag(String id);
    List<Tag> getTagsStartsWith(String str);
}

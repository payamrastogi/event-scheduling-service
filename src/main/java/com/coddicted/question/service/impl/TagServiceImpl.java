package com.coddicted.question.service.impl;

import com.coddicted.question.model.Tag;
import com.coddicted.question.repository.TagRepository;
import com.coddicted.question.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;

    @Override
    public List<Tag> getTags(Pageable paging) {
        return tagRepository.findAll(paging).toList();
    }

    @Override
    public Tag getTag(String id) {
        Optional<Tag> res =  tagRepository.findById(id);
        if(res.isPresent())
            return res.get();
        return null;
    }

    @Override
    public List<Tag> getTagsStartsWith(String str, Pageable paging) {
        return tagRepository.findByValueStartsWith(str, paging).toList();
    }

    @Override
    public Tag save(Tag tag){
        return tagRepository.save(tag);
    }
}

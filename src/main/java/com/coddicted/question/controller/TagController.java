package com.coddicted.question.controller;

import com.coddicted.question.model.Tag;
import com.coddicted.question.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/tags")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TagController {
    private TagService tagService;

    @GetMapping("/{id}")
    public Tag getTag(@PathVariable("id") String id){
        return tagService.getTag(id);
    }

    @GetMapping
    public List<Tag> getTags(@RequestParam(required = false, name= "startsWith") String startsWith,
            @RequestParam(defaultValue = "0", name="page") int page,
            @RequestParam(defaultValue = "10", name="size") int size){
        Pageable paging = PageRequest.of(page, size);
        if(StringUtils.hasText(startsWith)){
            return tagService.getTagsStartsWith(startsWith, paging);
        }
        return tagService.getTags(paging);
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag tag){
        return tagService.save(tag);
    }

    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable("id") String id, @RequestBody Tag tag){
        Tag existingTag = getTag(id);
        if(Objects.isNull(existingTag))
            return null;
        tag.setId(id);
        return tagService.save(tag);
    }


}

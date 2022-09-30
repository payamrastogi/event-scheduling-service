package com.coddicted.question.controller;

import com.coddicted.question.model.Tag;
import com.coddicted.question.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Tag> getTags(@RequestParam(required = false, name= "startsWith") String startsWith){
        if(StringUtils.hasText(startsWith)){
            return tagService.getTagsStartsWith(startsWith);
        }
        return tagService.getTags();
    }


}

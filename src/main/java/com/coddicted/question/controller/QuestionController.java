package com.coddicted.question.controller;

import com.coddicted.question.model.Question;
import com.coddicted.question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionController {
    private QuestionService questionService;

    @GetMapping
    public List<Question> getQuestions(@RequestParam(defaultValue = "0", name="page") int page,
                                       @RequestParam(defaultValue = "10", name="size") int size,
                                       @RequestParam(name = "tagId", required = false) String tagId){
        Pageable paging = PageRequest.of(page, size);
        if(StringUtils.hasText(tagId)){
            return questionService.getQuestionsByTagId(tagId);
        }
        return questionService.getQuestions(paging);
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable("id")  String id){
        return questionService.getQuestion(id);
    }


    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

}

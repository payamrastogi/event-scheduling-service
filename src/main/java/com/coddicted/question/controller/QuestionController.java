package com.coddicted.question.controller;

import com.coddicted.question.model.Question;
import com.coddicted.question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionController {
    private QuestionService questionService;

    @GetMapping
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }
}

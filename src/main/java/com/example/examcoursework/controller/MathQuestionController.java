package com.example.examcoursework.controller;

import com.example.examcoursework.Exception.ExceptionMethodNotAlowed;
import com.example.examcoursework.model.Question;
import com.example.examcoursework.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/math")
public class MathQuestionController {
    public final QuestionService questionService;

    public MathQuestionController(@Qualifier("MathQuestionServiceImpl") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question add(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping(path = "/find")
    public Set<Question> getAll() {
        throw new ExceptionMethodNotAlowed("Методы больше не существует");
    }
}

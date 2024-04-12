package com.example.examcoursework.controller;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.service.examiner.ExaminerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping
public class ExaminerController {
    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get/{amount}")
    public Set<Question> get(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}

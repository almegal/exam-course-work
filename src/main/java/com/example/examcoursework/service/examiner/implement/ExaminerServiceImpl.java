package com.example.examcoursework.service.examiner.implement;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.service.examiner.ExaminerService;
import com.example.examcoursework.service.question.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        return null;
    }
}

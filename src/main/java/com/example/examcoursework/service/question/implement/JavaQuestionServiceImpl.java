package com.example.examcoursework.service.question.implement;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.repository.QuestionRepository;
import com.example.examcoursework.service.question.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private QuestionRepository questions;

    public JavaQuestionServiceImpl(QuestionRepository questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Set<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}

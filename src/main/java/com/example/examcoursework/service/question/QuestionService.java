package com.example.examcoursework.service.question;

import com.example.examcoursework.model.Question;

import java.util.Set;

public interface QuestionService {
    public Question add(String question, String answer);
    public Question add(Question question);
    public Question remove(Question question);
    public Set<Question> getAll();
    public Question getRandomQuestion();
}

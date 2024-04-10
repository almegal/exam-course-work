package com.example.examcoursework.repository;

import com.example.examcoursework.model.Question;

import java.util.Set;

public interface QuestionRepository {
    public Question add(String question, String answer);
    public Question remove(Question question);
    public Set<Question> getAll();
}

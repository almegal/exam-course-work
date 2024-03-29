package com.example.examcoursework.repository.implement;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class JavaQuestionRepositoryImpl implements QuestionRepository {
    private Set<Question> questions;

    public JavaQuestionRepositoryImpl() {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
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
}

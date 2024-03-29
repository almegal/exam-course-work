package com.example.examcoursework.service.examiner;

import com.example.examcoursework.model.Question;

import java.util.Set;

public interface ExaminerService {
    public Set<Question> getQuestions(int amount);
}

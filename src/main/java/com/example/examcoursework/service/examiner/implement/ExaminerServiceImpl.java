package com.example.examcoursework.service.examiner.implement;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.service.examiner.ExaminerService;
import com.example.examcoursework.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(@Qualifier("JavaQuestionServiceImpl") QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Set<Question> getQuestions(int amount) {
        final Set<Question> questions = questionService.getAll();
        // получаем размер списка и проверяем что есть необходимое количество вопросов в списке
        final int size = questions.size();
        if(size < amount || size == 0) throw new IllegalArgumentException("Количество необходимых вопросов превышает размер списка или равно 0");
        // если количетсво необходимых вопросов равно размеру списка
        // вернуть сразу весь список
        if(size == amount) return questions;
        // создаем множество куда добавим уникальные вопросы и ответы
        Set<Question> result = new HashSet<>();
        // пока больше нуля
        while (amount > 0) {
            // получаем рандомные вопрос
            Question queston = questionService.getRandomQuestion();
            // проверяем что вопрос добавленный уникален
            boolean isAdded = result.add(queston);
            // если истинно уменьшаем значение
            if(isAdded) amount--;
        }
        return result;
    }
}

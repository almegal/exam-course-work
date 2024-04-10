package com.example.examcoursework.service.examiner.implement;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.service.examiner.ExaminerService;
import com.example.examcoursework.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(
            @Qualifier("JavaQuestionServiceImpl") QuestionService javaQuestionService,
            @Qualifier("MathQuestionServiceImpl") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }
    @Override
    public Set<Question> getQuestions(int amount) {
        final Set<Question> javaQuestions = javaQuestionService.getAll();
        final Set<Question> mathQuestions = javaQuestionService.getAll();
        // получаем размер списка и проверяем что есть необходимое количество вопросов в списке
        final int javaSize = javaQuestions.size();
        final int mathSize = mathQuestions.size();
        if((javaSize < amount || javaSize == 0) || (mathSize < amount || mathSize == 0)) {
            throw new IllegalArgumentException("Количество необходимых вопросов превышает размер списка или равно 0");
        }
        // создаем множество куда добавим уникальные вопросы и ответы
        Set<Question> result = new HashSet<>();
        // пока больше нуля
        while (result.size() < amount) {
            // получаем рандомные вопрос
            Question javaQuestion = javaQuestionService.getRandomQuestion();
            Question mathQuestion = mathQuestionService.getRandomQuestion();
            result.add(javaQuestion);
            result.add(mathQuestion);
        }
        return result;
    }
}

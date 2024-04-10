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
        final Set<Question> questions = javaQuestionService.getAll();
        // получаем размер списка и проверяем что есть необходимое количество вопросов в списке
        final int size = questions.size();
        if(size < amount || size == 0) throw new IllegalArgumentException("Количество необходимых вопросов превышает размер списка или равно 0");
        // создаем множество куда добавим уникальные вопросы и ответы
        Set<Question> result = new HashSet<>();
        // пока больше нуля
        while (amount > 0) {
            // получаем рандомные вопрос
            Question javaQuestion = javaQuestionService.getRandomQuestion();
            Question mathQuestion = mathQuestionService.getRandomQuestion();
            // проверяем что вопрос добавленный уникален
            boolean javaIsAdded = result.add(javaQuestion);
            boolean mathIsAdded = result.add(mathQuestion);
            // если истинно уменьшаем значение
            if(javaIsAdded && mathIsAdded) amount--;
        }
        return result;
    }
}

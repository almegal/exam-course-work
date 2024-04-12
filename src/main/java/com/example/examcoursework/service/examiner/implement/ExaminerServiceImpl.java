package com.example.examcoursework.service.examiner.implement;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.service.examiner.ExaminerService;
import com.example.examcoursework.service.question.QuestionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices;

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        // получаем общее количетсво вопросов
        int size = 0;
        for (QuestionService questionService : questionServices) {
            size = size + questionService.getAll().size();
        }
        // если общее количество вопросов меньше запрашиваемого
        // выбросить исключение
        if (size < amount || size == 0) {
            throw new IllegalArgumentException("Количество необходимых вопросов превышает размер списка или равно 0");
        }
        // создаем множество куда добавим уникальные вопросы и ответы
        Set<Question> result = new HashSet<>();
        //  пока больше нуля
        while (result.size() < amount) {
            // получаемый рандомный индекс сервиса
            int index = (int) Math.round(Math.random());
            // получаем рандомный вопрос
            // и добавляем в ответ
            Question question = questionServices.get(index).getRandomQuestion();
            result.add(question);
        }
        return result;
    }
}

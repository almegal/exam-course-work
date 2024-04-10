package com.example.examcoursework.service.question.implement;

import com.example.examcoursework.Exception.ExceptionMethodNotAlowed;
import com.example.examcoursework.model.Question;
import com.example.examcoursework.repository.QuestionRepository;
import com.example.examcoursework.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Random;
import java.util.Set;

@Service("MathQuestionServiceImpl")
public class MathQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions;
    private final Random random;

    public MathQuestionServiceImpl(Set<Question> DEFAULT_MATH_QUESTION,
            Random random) {
        this.questions = DEFAULT_MATH_QUESTION;
        this.random = random;
    }
    @Override
    public Question add(String question, String answer) {
        throw new ExceptionMethodNotAlowed("Методы больше не существует");
    }
    @Override
    public Question add(Question question) {
        throw new ExceptionMethodNotAlowed("Методы больше не существует");
    }
    @Override
    public Question remove(Question question) {
        throw new ExceptionMethodNotAlowed("Методы больше не существует");
    }
    @Override
    public Set<Question> getAll() {
        throw new ExceptionMethodNotAlowed("Методы больше не существует");
    }
    @Override
    public Question getRandomQuestion() {
        // получаем список вопросов
        Set<Question> allQuestions = questions;
        // используем бин из конфига для получения рандомного значения
        int questionNum = random.nextInt(allQuestions.size());
        // создаем стартовый индекс
        int index = 0;
        // проходим циклом по списку пока индекс не равен рандомному числу
        for (Question question : allQuestions) {
            if(index == questionNum) {
                return question;
            }
            index++;
        }
        throw new IllegalStateException("Что-то пошло не так при выборе рандомного елемента");
    }
}

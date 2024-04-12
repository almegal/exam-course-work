package com.example.examcoursework.service.question.implement;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.repository.QuestionRepository;
import com.example.examcoursework.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;

@Service("JavaQuestionServiceImpl")
public class JavaQuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final Random random;

    public JavaQuestionServiceImpl(
            @Qualifier("JavaQuestionRepositoryImpl") QuestionRepository questionRepository,
            Random random) {
        this.questionRepository = questionRepository;
        this.random = random;
    }

    @Override
    public Question add(String question, String answer) {
        return questionRepository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        // проверка аргумента
        checkArgs(question);
        return questionRepository.add(question.getQuestion(), question.getAnswer());
    }

    @Override
    public Question remove(Question question) {
        // проверка аргумента
        checkArgs(question);
        return questionRepository.remove(question);
    }

    @Override
    public Set<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        // получаем список вопросов
        Set<Question> allQuestions = getAll();
        // используем бин из конфига для получения рандомного значения
        int questionNum = random.nextInt(allQuestions.size());
        // создаем стартовый индекс
        int index = 0;
        // проходим циклом по списку пока индекс не равен рандомному числу
        for (Question question : allQuestions) {
            if (index == questionNum) {
                return question;
            }
            index++;
        }
        throw new IllegalStateException("Что-то пошло не так при выборе рандомного елемента");
    }

    // проверяем аргумент
    private void checkArgs(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Некорректный аргумент, метод ожидает Question, а переданы: null");
        }
    }
}

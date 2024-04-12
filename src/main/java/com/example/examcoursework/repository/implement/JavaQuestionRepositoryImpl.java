package com.example.examcoursework.repository.implement;

import com.example.examcoursework.Exception.ExceptionQuestionIsExsist;
import com.example.examcoursework.Exception.ExceptionQuestionIsNotExsist;
import com.example.examcoursework.model.Question;
import com.example.examcoursework.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Set;

@Repository("JavaQuestionRepositoryImpl")
public class JavaQuestionRepositoryImpl implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepositoryImpl(Set<Question> DEFAULT_JAVA_QUESTION_SET) {
        this.questions = DEFAULT_JAVA_QUESTION_SET;
    }

    @Override
    public Question add(String question, String answer) {
        // проверяем валидность аргументов
        checkArgs(question, answer);
        // создаем и добавляем во множество наш вопрос
        // и записываем результат добавления  true/false в переменную
        final Question q = new Question(question, answer);
        boolean isAdded = questions.add(q);
        // проверяем если вернулся false значит такой вопрос уже есть
        if (!isAdded) {
            throw new ExceptionQuestionIsExsist("Такой вопрос уже есть в списке");
        }
        return q;
    }

    @Override
    public Question remove(Question question) {
        // удаляем вопрос из сета
        // результат записываем в переменную
        boolean isRemoved = questions.remove(question);
        // если false значить не было такого вопроса в списке
        if (!isRemoved) {
            throw new ExceptionQuestionIsNotExsist("Такого вопроса нет в списке");
        }
        return question;
    }

    @Override
    public Set<Question> getAll() {
        // возращаем коллекцию только для чтения
        return Collections.unmodifiableSet(questions);
    }

    // проверка валидности аргумента
    private void checkArgs(String question, String answer) {
        if ((question == null || answer == null || question.isBlank() || answer.isBlank())) {
            String errorMsg = String.format("Некорректный аргумент, метод ожидает строку, а переданы: question: %s; answer: %s;", question, answer);
            throw new IllegalArgumentException(errorMsg);
        }
    }
}

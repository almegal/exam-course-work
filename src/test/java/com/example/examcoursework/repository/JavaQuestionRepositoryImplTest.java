package com.example.examcoursework.repository;

import com.example.examcoursework.Exception.ExceptionQuestionIsExsist;
import com.example.examcoursework.Exception.ExceptionQuestionIsNotExsist;
import com.example.examcoursework.model.Question;
import com.example.examcoursework.repository.implement.JavaQuestionRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionRepositoryImplTest {
    // константы
    private static final Question DEFAULT_QUESTION = new Question("Вопрос 1", "Ответ 1");
    private final QuestionRepository questionRepository = new JavaQuestionRepositoryImpl(new HashSet<>());
    @BeforeEach
    public void set_up(){
        questionRepository.add(DEFAULT_QUESTION.getQuestion(), DEFAULT_QUESTION.getAnswer());
    }
    //методы для Параметризованных тестов
    public static Stream<Arguments> argsProviderIncorrect(){
        return Stream.of(
                Arguments.of("", "Answer 1"),
                Arguments.of("Question 1", ""),
                Arguments.of(null, "Answer 1"),
                Arguments.of("Question 1", null),
                Arguments.of(null, null),
                Arguments.of("", "")

        );
    }
    //-------------------------------------НАЧАЛО ТЕСТОВ-----------------------------------------------
    @Test
    @DisplayName("Добавить вопрос")
    public void add() {
        // подготовка ожидаемого результата
        int expectedSize = 2;
        Question expectedQuestion = new Question("Вопрос 2", "Ответ 2");
        // подготовка актуального результата
        Question actualQuestion = questionRepository.add("Вопрос 2", "Ответ 2");
        int actualSize = questionRepository.getAll().size();
        // тест
        Assertions.assertEquals(expectedQuestion, actualQuestion);
        Assertions.assertEquals(expectedSize, actualSize);

    };
    @ParameterizedTest
    @MethodSource("argsProviderIncorrect")
    @DisplayName("Исключение если некорректные параметры")
    public void throwAddIfArgsIncorrect(String question, String answer){
        // подготовка ожидаемого результата
        String expectedErrorMsg = String.format("Некорректный аргумент, метод ожидает строку, а переданы: question: %s; answer: %s;", question, answer);
        // подготовка актуального резльтата
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> questionRepository.add(question, answer));
        // тест
        assertEquals(expectedErrorMsg, thrown.getMessage());
    }
    @Test
    @DisplayName("Исключение если вопрос уже есть в списке")
    public void throwAddIfQuestionIsExsist(){
        // подготовка ожидаемого результата
        String expectedErrorMsg = "Такой вопрос уже есть в списке";
        // подготовка актуального результата
        ExceptionQuestionIsExsist thrown = assertThrows(ExceptionQuestionIsExsist.class,
                ()-> questionRepository.add(DEFAULT_QUESTION.getQuestion(), DEFAULT_QUESTION.getAnswer()));
        // тест
        assertEquals(expectedErrorMsg, thrown.getMessage());
    }
    @Test
    @DisplayName("Удалить вопрос")
    public void remove(){
        // подготовка актуального результата
        Question actual = questionRepository.remove(DEFAULT_QUESTION);
        // тест
        assertEquals(DEFAULT_QUESTION, actual);
        assertEquals(0, questionRepository.getAll().size());
    };
    @Test
    @DisplayName("Исключение если вопроса нет в списке")
    public void throwRemoveIfQuestionNotExsist(){
        // подготовка ожидемого результата
        String errorMessage = "Такого вопроса нет в списке";
        // подгтовка актуального результата
        ExceptionQuestionIsNotExsist thrown = assertThrows(ExceptionQuestionIsNotExsist.class,
                () -> questionRepository.remove(new Question("Вопрос 2", "Ответ 2")));
        // тест
        assertEquals(errorMessage, thrown.getMessage());
    }
    @Test
    public void  getAll(){
        // подготовка ожидаемого результата
        Set<Question> expexted = Set.of(DEFAULT_QUESTION);
        // подготовка актуального результата
        Set<Question> actual = questionRepository.getAll();
        // тест
        assertEquals(expexted, actual);
    };
    //-------------------------------------КОНЕЦ ТЕСТОВ-----------------------------------------------
}

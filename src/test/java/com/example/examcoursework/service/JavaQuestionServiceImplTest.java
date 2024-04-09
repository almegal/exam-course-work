package com.example.examcoursework.service;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.repository.QuestionRepository;
import com.example.examcoursework.service.question.implement.JavaQuestionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {
    @Mock
    private QuestionRepository questionRepositoryMock;
    @Mock
    private Random randomMock;
    @InjectMocks
    private JavaQuestionServiceImpl out;
    // константы
    private final Question DEFAULT_QUESTION = new Question("Вопрос 1","Ответ 1");
    private final Set<Question> DEFAULT_QUESTION_SET = Set.of(
            new Question("Вопрос 1", "Ответ 1"),
            new Question("Вопрос 2", "Ответ 2"),
            new Question("Вопрос 3", "Ответ 3"),
            new Question("Вопрос 4", "Ответ 4"));
    //----------------------------НАЧАЛО ТЕСТА -----------------------------------------------------//
    @Test
    @DisplayName("Добавить вопрос")
    public void addWithCorrectParametr(){
        // подготовка ожидаемого результата
        when(questionRepositoryMock.add(anyString(), anyString())).thenReturn(DEFAULT_QUESTION);
        // подготовка актуального значения
        Question actualWIthTwoArgs = out.add(anyString(), anyString());
        Question actualWIthQuestionArgs = out.add(DEFAULT_QUESTION);
        // тест
        assertEquals(DEFAULT_QUESTION, actualWIthQuestionArgs);
        assertEquals(DEFAULT_QUESTION, actualWIthTwoArgs);
        verify(questionRepositoryMock, times(2)).add(anyString(), anyString());
    }
    @Test
    @DisplayName("Исключение если аргументы не корректны метод add")
    public void addWithIncorrectArgs(){
        // подготовка ожидаемого результата
        String expectedMsg = "Некорректный аргумент, метод ожидает Question, а переданы: null";
        // подготовка актуального результата
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> {
                    out.add(null);
                });
        // тест
        assertEquals(expectedMsg, thrown.getMessage());
    }
    @Test
    @DisplayName("Удалить вопрос")
    public void removeIfQuesitonExsist(){
        // подготовка ожидаемого результата
        when(questionRepositoryMock.remove(any())).thenReturn(DEFAULT_QUESTION);
        // подготовка актуального результата
        Question actual = out.remove(DEFAULT_QUESTION);
        // тест
        assertEquals(DEFAULT_QUESTION, actual);
        verify(questionRepositoryMock, times(1)).remove(any());
    }
    @Test
    @DisplayName("Исключение если аргументы не корректны метод remove")
    public void removeWithIncorrectArgs(){
        // подготовка ожидаемого результата
        String expectedMsg = "Некорректный аргумент, метод ожидает Question, а переданы: null";
        // подготовка актуального результата
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> {
                    out.remove(null);
                });
        // тест
        assertEquals(expectedMsg, thrown.getMessage());
    }
    @Test
    @DisplayName("Получить список вопросов")
    public void getAllQuestions(){
        // подготовка ожидаемого результата
        when(questionRepositoryMock.getAll()).thenReturn(DEFAULT_QUESTION_SET);
        // подготовка ожидаемого результата
        Set<Question> actual = out.getAll();
        // тест
        assertEquals(DEFAULT_QUESTION_SET, actual);
        verify(questionRepositoryMock, only()).getAll();
    }
    @Test
    @DisplayName("получить рандомный вопрос")
    public void getRandomQuestion(){
        // подготовка ожидаемого результата
        when(questionRepositoryMock.getAll()).thenReturn(DEFAULT_QUESTION_SET);
        when(randomMock.nextInt(anyInt())).thenReturn(3);
        Question expected = new ArrayList<Question>(DEFAULT_QUESTION_SET).get(3 - 1);
        // подготовка акутального результата
        Question actual = out.getRandomQuestion();
        // тест
        assertEquals(expected, actual);
        verify(randomMock, only()).nextInt(anyInt());
        verify(questionRepositoryMock, only()).getAll();
    }
}

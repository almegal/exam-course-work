package com.example.examcoursework.service;

import com.example.examcoursework.model.Question;
import com.example.examcoursework.service.examiner.ExaminerService;
import com.example.examcoursework.service.examiner.implement.ExaminerServiceImpl;
import com.example.examcoursework.service.question.QuestionService;
import com.example.examcoursework.service.question.implement.JavaQuestionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    @DisplayName("Получить рандомные вопросы")
    public void getAmountQuestions() {
        // подготовка ожидаемого результата
        Set<Question> expected = Set.of(new Question("Вопрос 1", "Ответ 1"));
        when(javaQuestionService.getAll()).thenReturn(expected);
        when(javaQuestionService.getRandomQuestion()).thenReturn(new Question("Вопрос 1", "Ответ 1"));
        // подготовка актуального результата
        Set<Question> actual = out.getQuestions(1);
        // тест
        assertEquals(expected, actual);
        verify(javaQuestionService, times(2)).getRandomQuestion();
    }
}

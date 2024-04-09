package com.example.examcoursework.Configuration;

import com.example.examcoursework.model.Question;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.Set;

@Configuration
public class Config {
    @Bean
    Random random(){
        return new Random();
    }

    @Bean
    Set<Question> DEFAULT_QUESTION_SET() {
        return Set.of(
                new Question("Вопрос 1", "Ответ 1"),
                new Question("Вопрос 2", "Ответ 2"),
                new Question("Вопрос 3", "Ответ 3"),
                new Question("Вопрос 4", "Ответ 4"),
                new Question("Вопрос 5", "Ответ 5"),
                new Question("Вопрос 6", "Ответ 6"),
                new Question("Вопрос 7", "Ответ 7"),
                new Question("Вопрос 8", "Ответ 8")
        );
    }
}

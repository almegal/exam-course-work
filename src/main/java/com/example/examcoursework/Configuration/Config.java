package com.example.examcoursework.Configuration;

import com.example.examcoursework.model.Question;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Configuration
public class Config {
    @Bean
    Random random(){
        return new Random();
    }

    @Bean
    Set<Question> DEFAULT_JAVA_QUESTION_SET() {
        return new HashSet<>(Arrays.asList(
                new Question("Что такое ООП?", "Объектно-ориентированное программирование (ООП) — методология программирования, основанная на представлении программы в виде совокупности объектов, каждый из которых является экземпляром определенного класса, а классы образуют иерархию наследования." +
                        "" +
                        "объектно-ориентированное программирование использует в качестве основных логических конструктивных элементов объекты, а не алгоритмы;" +
                        "каждый объект является экземпляром определенного класса" +
                        "классы образуют иерархии."),
                new Question("Что такое «инкапсуляция»?", "Инкапсуляция – это свойство системы, позволяющее объединить данные и методы, работающие с ними, в классе и скрыть детали реализации от пользователя, открыв только то, что необходимо при последующем использовании."),
                new Question("Что такое «полиморфизм»?", "Полиморфизм – это свойство системы использовать объекты с одинаковым интерфейсом без информации о типе и внутренней структуре объекта."),
                new Question("Что такое «коллекция»?", "«Коллекция» - это структура данных, набор каких-либо объектов. Данными (объектами в наборе) могут быть числа, строки, объекты пользовательских классов и т.п."),
                new Question("Почему Map — это не Collection, в то время как List и Set являются Collection?", "Collection представляет собой совокупность некоторых элементов. Map - это совокупность пар «ключ-значение»."),
                new Question("Что произойдет при вызове Iterator.next() без предварительного вызова Iterator.hasNext()?", "Если итератор указывает на последний элемент коллекции, то возникнет исключение NoSuchElementException, иначе будет возвращен следующий элемент." +
                        ""),
                new Question("Что такое «модульное тестирование»?", "Модульное/компонентное тестирование (unit testing) - процесс в программировании, позволяющий проверить на корректность отдельные модули исходного кода программы. Идея состоит в том, чтобы писать тесты для каждой нетривиальной функции или метода. Это позволяет достаточно быстро проверить, не привело ли очередное изменение кода к регрессии, то есть к появлению ошибок в уже оттестированных местах программы, а также облегчает обнаружение и устранение таких ошибок."),
                new Question("Чем stub отличается от mock?", "stub используется как заглушка сервисов, методов, классов и т.д. с заранее запрограммированным ответом на вызовы." +
                        "" +
                        "mock использует подмену результатов вызова, проверяет сам факт взаимодействия, протоколирует и контролирует его." +
                        "")
        ));
    }
    @Bean
    Set<Question> DEFAULT_MATH_QUESTION(){
        return new HashSet<>(Arrays.asList(
                new Question("Число, у которого нет собственного числа?", "0"),
                new Question("Назовите единственное четное простое число?", "Две"),
                new Question("9*N равно 108. Что такое N?", "N = 12"),
                new Question("Кто изобрел знак равенства '='?", "Роберт Рекорд."),
                new Question("Значение Пи?", "3.14159")
        ));
    }
}

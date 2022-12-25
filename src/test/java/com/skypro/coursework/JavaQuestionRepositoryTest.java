package com.skypro.coursework;

import com.skypro.hw_spring.coursework.model.Question;
import com.skypro.hw_spring.coursework.repository.impl.JavaQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class JavaQuestionRepositoryTest {

    private JavaQuestionRepository repository;
    private static final Question QUESTION = new Question("Question1", "Answer1");
    private static final Question QUESTION1 = new Question("Question2", "Answer2");
    private static final Question QUESTION2 = new Question("Question3", "Answer3");

    @BeforeEach
    void setUp() {
        repository = new JavaQuestionRepository();
        repository.add(QUESTION1);
        repository.add(QUESTION2);
    }

    @Test
    void addTest() {
        repository.add(QUESTION);
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        excepted.add(QUESTION);
        assertEquals(repository.getAll(), excepted);
    }

    @Test
    void addSameObjectTest() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        repository.add(QUESTION1);
        assertEquals(repository.getAll(), excepted);

    }

    @Test
    void removeTest() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        repository.remove(QUESTION2);
        assertEquals(repository.getAll(), excepted);
    }

    @Test
    void removeNonExistedObjectTest() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        repository.remove(QUESTION);
        assertEquals(repository.getAll(), excepted);
    }

    @Test
    void getAllTest() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        assertEquals(repository.getAll(), excepted);
    }

    @Test
    void getAllEmptySetTest() {
        Set<Question> excepted = new HashSet<>();
        repository.remove(QUESTION1);
        repository.remove(QUESTION2);
        assertEquals(repository.getAll(), excepted);
    }
}
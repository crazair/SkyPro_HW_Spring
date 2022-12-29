package com.skypro.coursework;

import com.skypro.hw_spring.coursework.model.Question;
import com.skypro.hw_spring.coursework.service.impl.MathQuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceTest {
    private static final Question QUESTION2 = new Question("2 + 2", " = 4");
    private final MathQuestionService questionService = new MathQuestionService();

    @Test
    void addTest() {
        assertThrows(ResponseStatusException.class, () -> questionService.add(QUESTION2));
    }

    @Test
    void addStringsTest() {
        assertThrows(ResponseStatusException.class, () -> questionService.add("2 + 2", " = 4"));
    }

    @Test
    void removeTest() {
        assertThrows(ResponseStatusException.class, () -> questionService.remove(QUESTION2));
    }

    @Test
    void getAllTest() {
        assertThrows(ResponseStatusException.class, questionService::getAll);
    }

    @Test
    void getSizeTest() {
        assertThrows(ResponseStatusException.class, questionService::getSize);
    }

    @Test
    void getRandomTest() {
        assertNotNull(questionService.getRandomQuestion());
    }

    @Test
    void getRandomAnswerTest() {
        assertTrue(questionService.getRandomQuestion().getAnswer() instanceof String);
    }

    @Test
    void getRandomAskTest() {
        assertTrue(questionService.getRandomQuestion().getQuestion() instanceof String);
    }
}
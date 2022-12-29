package com.skypro.coursework;

import com.skypro.hw_spring.coursework.model.Question;
import com.skypro.hw_spring.coursework.repository.QuestionRepository;
import com.skypro.hw_spring.coursework.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @Mock
    private QuestionRepository questions;
    private static final Question QUESTION1 = new Question("Question1", "Answer1");
    private static final Question QUESTION2 = new Question("Question2", "Answer2");
    private final Collection<Question> setQuestion = Set.of(QUESTION1, QUESTION2);

    @Test
    void addObjectTest() {
        when(questions.add(QUESTION2)).thenReturn(QUESTION2);
        assertEquals(javaQuestionService.add(QUESTION2), QUESTION2);
    }

    @Test
    void addTest() {
        when(questions.add(new Question("Question2", "Answer2"))).thenReturn(QUESTION2);
        assertEquals(javaQuestionService.add("Question2", "Answer2"), QUESTION2);
    }

    @Test
    void removeTest() {
        when(questions.remove(QUESTION2)).thenReturn(QUESTION2);
        assertEquals(javaQuestionService.remove(QUESTION2), QUESTION2);
    }

    @Test
    void getAllTest() {
        when(questions.getAll()).thenReturn(setQuestion);
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void getAllEmptySetTest() {
        Set<Question> excepted = new HashSet<>();
        when(questions.getAll()).thenReturn(new HashSet<>());
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void getRandomQuestionTest() {
        when(questions.getAll()).thenReturn(setQuestion);
        Question temp = javaQuestionService.getRandomQuestion();
        assertTrue(temp.equals(QUESTION1) || temp.equals(QUESTION2));
    }

    @Test
    void getRandomQuestionEmptySetTest() {
        when(questions.getAll()).thenReturn(new HashSet<>());
        assertThrows(ResponseStatusException.class, () -> javaQuestionService.getRandomQuestion());
    }

    @Test
    void getSizeTest() {
        when(questions.getAll()).thenReturn(setQuestion);
        assertEquals(2, javaQuestionService.getSize());
    }

    @Test
    void validateStringTest() {
        try {
            Method method = JavaQuestionService.class.getDeclaredMethod("validateString", String.class);
            method.setAccessible(true);
            method.invoke(javaQuestionService, (Object) null);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            assertEquals(ResponseStatusException.class, e.getCause().getClass());
        }
    }

    @Test
    void validateQuestionTest() {
        try {
            Method method = JavaQuestionService.class.getDeclaredMethod("validateQuestion", Question.class);
            method.setAccessible(true);
            method.invoke(javaQuestionService, (Object) null);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            assertEquals(ResponseStatusException.class, e.getCause().getClass());
        }
    }
}
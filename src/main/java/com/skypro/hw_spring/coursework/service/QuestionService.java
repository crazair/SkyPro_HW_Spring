package com.skypro.hw_spring.coursework.service;

import com.skypro.hw_spring.coursework.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int getSize();
}
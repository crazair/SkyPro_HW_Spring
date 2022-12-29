package com.skypro.hw_spring.coursework.repository;

import com.skypro.hw_spring.coursework.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
package com.skypro.hw_spring.coursework.service;

import com.skypro.hw_spring.coursework.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
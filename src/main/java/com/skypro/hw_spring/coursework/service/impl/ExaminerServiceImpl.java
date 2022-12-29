package com.skypro.hw_spring.coursework.service.impl;

import com.skypro.hw_spring.coursework.model.Question;
import com.skypro.hw_spring.coursework.service.ExaminerService;
import com.skypro.hw_spring.coursework.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> services;

    public ExaminerServiceImpl(List<QuestionService> services) {
        this.services = services;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Random random = new Random();
        Collection<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            int a = random.nextInt(2);
            questions.add(services.get(a).getRandomQuestion());
        }
        return questions;
    }
}
package com.skypro.hw_spring.coursework.repository.impl;

import com.skypro.hw_spring.coursework.model.Question;
import com.skypro.hw_spring.coursework.repository.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Collection<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("Question1", "Answer1"));
        questions.add(new Question("Question2", "Answer2"));
        questions.add(new Question("Question3", "Answer3"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
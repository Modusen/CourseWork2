package com.example.CourseWork2.QuestionPackage;

import java.util.ArrayList;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    ArrayList<Question> getAll();

    Question getRandomQuestion();

}

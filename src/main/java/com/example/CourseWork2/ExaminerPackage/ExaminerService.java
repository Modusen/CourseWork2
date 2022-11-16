package com.example.CourseWork2.ExaminerPackage;

import com.example.CourseWork2.QuestionPackage.Question;

import java.util.ArrayList;

public interface ExaminerService {
    ArrayList<Question> getQuestions(int amount);
}

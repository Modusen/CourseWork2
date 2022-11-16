package com.example.CourseWork2.ExaminerPackage;

import com.example.CourseWork2.QuestionPackage.JavaQuestionService;
import com.example.CourseWork2.QuestionPackage.MathQuestionService;
import com.example.CourseWork2.QuestionPackage.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public ArrayList<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getSizeOfCollection() + mathQuestionService.getSizeOfCollection()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Random random = new Random();
        ArrayList<Question> result = new ArrayList<>();
        int javaQuestionQuantity = random.nextInt(amount);
        if (javaQuestionQuantity > javaQuestionService.getSizeOfCollection()) {
            javaQuestionQuantity = javaQuestionService.getSizeOfCollection();
        }
        for (int i = 0; i < javaQuestionQuantity; i++) {
            Question temp = javaQuestionService.getRandomQuestion();
            if (!(result.contains(temp))) {
                result.add(temp);
            } else {
                i--;
            }
        }
        int mathQuestionQuantity = amount - javaQuestionQuantity;
        for (int i = 0; i < mathQuestionQuantity; i++) {
            Question temp = mathQuestionService.getRandomQuestion();
            if (!(result.contains(temp))) {
                result.add(temp);
            } else {
                i--;
            }
        }
        return result;
    }
}

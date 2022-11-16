package com.example.CourseWork2;

import com.example.CourseWork2.QuestionPackage.MathQuestionService;
import com.example.CourseWork2.QuestionPackage.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MathQuestionServiceTest {

    MathQuestionService mathQuestionService = new MathQuestionService();

    @Test
    public void addPositiveTest() {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        questionArrayList.add(mathQuestionService.add("question", "answer"));
        Assertions.assertEquals(new Question("question", "answer"), questionArrayList.get(0));
    }

    @Test
    public void addPositiveTest1() {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        Question result = new Question("question", "answer");
        questionArrayList.add(mathQuestionService.add(result));
        Assertions.assertEquals(new Question("question", "answer"), questionArrayList.get(0));
    }

    @Test
    public void removePositiveTest1() {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        Question result = new Question("question", "answer");
        Question result1 = new Question("question1", "answer1");

        questionArrayList.add(mathQuestionService.add(result));
        questionArrayList.add(mathQuestionService.add(result1));
        questionArrayList.remove(mathQuestionService.remove(result));

        Assertions.assertEquals(new Question("question1", "answer1"), questionArrayList.get(0));
    }

    @Test
    public void getAllPositiveTest1() {
        ArrayList<Question> resultList = new ArrayList<>();
        Question result = new Question("question", "answer");
        Question result1 = new Question("question1", "answer1");
        resultList.add(mathQuestionService.add(result));
        resultList.add(mathQuestionService.add(result1));
        ArrayList<Question> actual = mathQuestionService.getAll();


        ArrayList<Question> expected = new ArrayList<>();
        expected.add(result);
        expected.add(result1);

        Assertions.assertEquals(expected, actual);
    }
}

package com.example.CourseWork2;

import com.example.CourseWork2.QuestionPackage.JavaQuestionService;
import com.example.CourseWork2.QuestionPackage.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class JavaQuestionServiceTest {

    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void addPositiveTest() {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        questionArrayList.add(javaQuestionService.add("question", "answer"));
        Assertions.assertEquals(new Question("question", "answer"), questionArrayList.get(0));
    }

    @Test
    public void addPositiveTest1() {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        Question result = new Question("question", "answer");
        questionArrayList.add(javaQuestionService.add(result));
        Assertions.assertEquals(new Question("question", "answer"), questionArrayList.get(0));
    }

    @Test
    public void removePositiveTest1() {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        Question result = new Question("question", "answer");
        Question result1 = new Question("question1", "answer1");

        questionArrayList.add(javaQuestionService.add(result));
        questionArrayList.add(javaQuestionService.add(result1));
        questionArrayList.remove(javaQuestionService.remove(result));

        Assertions.assertEquals(new Question("question1", "answer1"), questionArrayList.get(0));
    }

    @Test
    public void getAllPositiveTest1() {
        ArrayList<Question> resultList = new ArrayList<>();
        Question result = new Question("question", "answer");
        Question result1 = new Question("question1", "answer1");
        resultList.add(javaQuestionService.add(result));
        resultList.add(javaQuestionService.add(result1));
        ArrayList<Question> actual = javaQuestionService.getAll();


        ArrayList<Question> expected = new ArrayList<>();
        expected.add(result);
        expected.add(result1);

        Assertions.assertEquals(expected, actual);
    }

}

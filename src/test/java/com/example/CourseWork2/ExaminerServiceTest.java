package com.example.CourseWork2;

import com.example.CourseWork2.ExaminerPackage.ExaminerService;
import com.example.CourseWork2.ExaminerPackage.ExaminerServiceImpl;
import com.example.CourseWork2.QuestionPackage.JavaQuestionService;
import com.example.CourseWork2.QuestionPackage.MathQuestionService;
import com.example.CourseWork2.QuestionPackage.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @Mock
    private MathQuestionService mathQuestionService;

    private ExaminerServiceImpl examinerService;
    @BeforeEach
    public void setUp() {
        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
    }

    @Test
    public void randomQuestionListTest() {

        Question question = new Question("JavaQuestion", "JavaAnswer");
        Question question1 = new Question("MathQuestion", "MathAnswer");
        ArrayList<Question> expected = new ArrayList<>();
        expected.add(question);
        expected.add(question1);

        Mockito.when(javaQuestionService.getSizeOfCollection()).thenReturn(1);
        Mockito.when(mathQuestionService.getSizeOfCollection()).thenReturn(1);

        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(question1);
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);

        ArrayList<Question> actual = examinerService.getQuestions(2);
        assertEquals(expected, actual);
    }
}

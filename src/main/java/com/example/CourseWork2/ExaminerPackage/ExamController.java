package com.example.CourseWork2.ExaminerPackage;

import com.example.CourseWork2.QuestionPackage.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/exam/random")
    public ArrayList<Question> getQuestions(@RequestParam(value = "amount") int amount) {
        return examinerService.getQuestions(amount);
    }

}

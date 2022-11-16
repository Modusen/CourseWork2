package com.example.CourseWork2.QuestionPackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/exam/math")
public class MathQuestionController {
    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping(path = "/add")
    public Question add(@RequestParam(value = "question") String question, @RequestParam(value = "answer") String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam(value = "question") String question, @RequestParam(value = "answer") String answer) {
        Question result = new Question(question, answer);
        return mathQuestionService.remove(result);
    }

    @GetMapping(path = "")
    public ArrayList<Question> getAll() {
        return mathQuestionService.getAll();
    }

}

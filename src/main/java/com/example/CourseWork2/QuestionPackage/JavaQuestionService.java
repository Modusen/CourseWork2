package com.example.CourseWork2.QuestionPackage;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    ArrayList<Question> questionList = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        questionList.add(new Question(question, answer));
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        questionList.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionList.remove(question);
        return question;
    }

    @Override
    public ArrayList<Question> getAll() {
        return questionList;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomIndexOfQuestion = random.nextInt(questionList.size());
        return questionList.get(randomIndexOfQuestion);
    }

    public int getSizeOfCollection() {
        return questionList.size();
    }
}

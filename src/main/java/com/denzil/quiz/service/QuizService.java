package com.denzil.quiz.service;

import com.denzil.quiz.dao.QuestionDao;
import com.denzil.quiz.dao.QuizDao;
import com.denzil.quiz.model.Question;
import com.denzil.quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions =questionDao.findRandomQuestionByCategory(category, numQ);
   Quiz quiz = new Quiz();
   quiz.setTitle(title);
    quiz.setQuestions(questions);
    quizDao.save(quiz);
    return new ResponseEntity<>("sucsess", HttpStatus.CREATED);
    }


}

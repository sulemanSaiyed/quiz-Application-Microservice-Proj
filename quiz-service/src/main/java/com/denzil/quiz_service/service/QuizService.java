package com.denzil.quiz_service.service;
import com.denzil.quiz_service.feign.QuizInterface;
import com.denzil.quiz_service.model.QuizDto;
import com.denzil.quiz_service.dao.QuizDao;

import com.denzil.quiz_service.model.QuestionWrapper;
import com.denzil.quiz_service.model.Quiz;
import com.denzil.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
      List<Integer> questions =quizInterface.getQuestionsForQuiz(category, numQ).getBody();
      Quiz quiz = new Quiz();
      quiz.setTitle(title);
      quiz.setQuestionIds(questions);
      quizDao.save(quiz);

    return new ResponseEntity<>("sucsess", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
       Quiz  quiz= quizDao.findById(id).get();
List<Integer> questionIds = quiz.getQuestionIds();

ResponseEntity<List<QuestionWrapper>>questionsss=quizInterface.getAllQuestionsFromId(questionIds);
       return  questionsss;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
ResponseEntity<Integer>score=quizInterface.getScores(responses);


        return score;


    }
}

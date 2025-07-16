package com.denzil.quiz.controller;

import com.denzil.quiz.model.Question;
import com.denzil.quiz.model.QuestionWrapper;
import com.denzil.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {

return quizService.createQuiz(category,numQ, title);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
return quizService.getQuizQuestion(id);
    }
}

package com.denzil.quiz.controller;

import com.denzil.quiz.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Quiz")
public class QuizController {
    QuizService quizService;
    @PostMapping("create")
public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {

return new ResponseEntity<>(" working", HttpStatus.CREATED);
    }
}

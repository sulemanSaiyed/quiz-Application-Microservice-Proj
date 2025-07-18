package com.denzil.quiz_service.controller;
import com.denzil.quiz_service.model.QuestionWrapper;
import com.denzil.quiz_service.model.QuizDto;
import com.denzil.quiz_service.model.Response;
import com.denzil.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {

return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(), quizDto.getTitle());
    }
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
return quizService.getQuizQuestion(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id, @RequestBody List<Response>responses) {
        return  quizService.calculateResult(id, responses);

    }
}

package com.denzil.question_service.controller;


import com.denzil.question_service.model.Question;
import com.denzil.question_service.model.QuestionWrapper;
import com.denzil.question_service.model.Response;
import com.denzil.question_service.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;



    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {

            return questionService.getAllQuestions();
    }


    @GetMapping("category/{category}")
    public ResponseEntity<List<Question> >getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory (category);

    }
    @PostMapping("add")
    public ResponseEntity<String >addQuestion(@RequestBody Question question){

       return questionService.addQuestion  (question);
    }
    @GetMapping("genrate")
    public ResponseEntity<List<Integer>>getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numberOfQuestions){
return questionService.getQuestionForQuiz(categoryName, numberOfQuestions);
    }
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>>getAllQuestionsFromId(@RequestBody List<Integer> ids){
        return  questionService.getQuestionsfromId(ids);


    }
    @PostMapping("getscore")
    public ResponseEntity<Integer>getScores(@RequestBody List<Response> responses){

        return questionService.getScore(responses);
    }
}

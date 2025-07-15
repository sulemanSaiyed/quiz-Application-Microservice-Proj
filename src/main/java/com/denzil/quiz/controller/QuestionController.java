package com.denzil.quiz.controller;

import com.denzil.quiz.Question;

import com.denzil.quiz.dao.QuestionDao;
import com.denzil.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
  QuestionService questionService;

    @Autowired
    private QuestionDao questionDao;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){

        return  questionService.getAllQuestions();
    }


    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionDao.findByCategory(category);

    }
    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){

       return questionService.addQuestion(question);
    }
}

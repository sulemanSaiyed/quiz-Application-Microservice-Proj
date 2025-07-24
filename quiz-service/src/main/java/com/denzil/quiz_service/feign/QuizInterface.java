package com.denzil.quiz_service.feign;

import com.denzil.quiz_service.model.QuestionWrapper;
import com.denzil.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/genrate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numberOfQuestions);
    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>>getAllQuestionsFromId(@RequestBody List<Integer> ids);
    @PostMapping("question/getscore")
    public ResponseEntity<Integer>getScores(@RequestBody List<Response> responses);
}

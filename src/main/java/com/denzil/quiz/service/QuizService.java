package com.denzil.quiz.service;

import com.denzil.quiz.dao.QuestionDao;
import com.denzil.quiz.dao.QuizDao;
import com.denzil.quiz.model.Question;
import com.denzil.quiz.model.QuestionWrapper;
import com.denzil.quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
       Optional<Quiz> quiz= quizDao.findById(id);
       List<Question> questionFromDb= quiz.get().getQuestions();
       List<QuestionWrapper> questionForUser= new ArrayList<>();
       for (Question pp : questionFromDb) {
           QuestionWrapper qw= new QuestionWrapper(pp.getId(), pp.getQuestionTitle(),pp.getOption1(), pp.getOption2(), pp.getOption3(),pp.getOption4());
           questionForUser.add(qw);

       }
       return  new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }
}

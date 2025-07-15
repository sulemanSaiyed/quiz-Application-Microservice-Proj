package com.denzil.quiz.service;

import com.denzil.quiz.Question;
import com.denzil.quiz.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestion(){
         return questionDao.findAll()  ;

    }


}

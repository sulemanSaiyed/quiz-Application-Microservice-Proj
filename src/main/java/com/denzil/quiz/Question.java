package com.denzil.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private  Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String dificultylevel;
}

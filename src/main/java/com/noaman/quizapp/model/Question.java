package com.noaman.quizapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String questionTitle;


    private String option1;
    private String option2;
    private String option3;
    private String difficultyLevel;
    private String rightAnswer;


}

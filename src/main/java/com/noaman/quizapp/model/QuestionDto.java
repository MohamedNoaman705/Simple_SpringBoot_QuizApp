package com.noaman.quizapp.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private int id;
    private Category category;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;

}
